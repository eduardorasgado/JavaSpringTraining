package com.eduardocode.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eduardocode.app.model.Pelicula;
import com.eduardocode.app.service.IPeliculasService;
import com.eduardocode.app.utils.Utility;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

	@Autowired
	private IPeliculasService peliculasService;
	
	@GetMapping("/index")
	public String showIndex(Model model) {
		List<Pelicula> listaPeliculas = peliculasService.getAll();
		
		model.addAttribute("peliculas", listaPeliculas);
		
		return "peliculas/listPeliculas";
	}
	
	@GetMapping("/create")
	public String create(@ModelAttribute Pelicula pelicula, Model model) {
		// el metodo create debe tener un modelo de clase pelicula
		// ya que en la vista que regresa este metodo se usa
		// un form con for tag library de spring
		List<String> generos = peliculasService.searchGenres();
		List<String> clasificaciones = peliculasService.searchPEGI();
		
		model.addAttribute("generos", generos);
		model.addAttribute("clasificaciones", clasificaciones);
		
		return "peliculas/formPelicula";
	}
	
	@PostMapping("/save")
	public String saveMovie(
			// si hay un metodo get que regresa una vista con form tag library
			// su metodo post tambien debe de manejar la clase dada con el model
			// attribute
			@ModelAttribute Pelicula pelicula,
			// flash attributes que permiten mandar datos
			// a una redireccion
			RedirectAttributes attributes,
			// permite tomar una imagen de un formulario
			@RequestParam("imagenArchivo") MultipartFile multiPart,
			// para recuperar la ruta absoluta del directorio images
			HttpServletRequest request,
			// con BindingResult podemos obtener posibles errores en el
			// data binding
			BindingResult result,
			Model model) {
		
		// manejando los errores con el binding result
		if(result.hasErrors()) {
			// solo retornamos la vista
			for(ObjectError error : result.getAllErrors()) {
				// imprimiendo cada uno de los posibles errores
				System.out.println(error.getDefaultMessage());
			}
			
			List<String> generos = peliculasService.searchGenres();
			
			model.addAttribute("generos", generos);
			return "peliculas/formPelicula";
		}
		
		//- despues de validar guardamos la imagen 
		if(!multiPart.isEmpty()) {
			String nombreImagen = Utility.guardarImagen(multiPart, request);
			// ahora si guardamos el nombre de la imagen, una vez esta es
			// obtenida
			pelicula.setImagen(nombreImagen);
		}
		peliculasService.insert(pelicula);
		
		System.out.println("Una pelicula se ha guardado:");
		System.out.println(pelicula);
		
		attributes.addFlashAttribute("message", "La película ha sido guardada con éxito");
		
		// si todo sale bien se redirige al user al listado
		return "redirect:/peliculas/index";
	}
	
	
	// uitilidades
	
	// anotacion init binder -> personalizar data binding
	// dada la anotacion initbinder esta sera autodetectada una vez creada 
	// la funcion y anotada
	@InitBinder
	private void peliculaInitBinder(WebDataBinder binder, ServletRequestDataBinder b2) {
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		// ultimo false no permitira fechas vacias
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(dateFormatter, false));
	}
}
