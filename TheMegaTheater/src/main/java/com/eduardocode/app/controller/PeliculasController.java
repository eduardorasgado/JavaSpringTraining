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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eduardocode.app.model.Pelicula;
import com.eduardocode.app.service.IDetallesService;
import com.eduardocode.app.service.IPeliculasService;
import com.eduardocode.app.utils.Utility;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

	@Autowired
	private IPeliculasService peliculasService; // implementa jpa en su imp
	@Autowired
	private IDetallesService detallesService;
	
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
		model = this.addGenerosAndCalificaciones(model);
		
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
			
			model = this.addGenerosAndCalificaciones(model);
			
			return "peliculas/formPelicula";
		}
		
		//- despues de validar guardamos la imagen 
		if(!multiPart.isEmpty()) {
			String nombreImagen = Utility.guardarImagen(multiPart, request);
			// ahora si guardamos el nombre de la imagen, una vez esta es
			// obtenida
			pelicula.setImagen(nombreImagen);
		}
		
		// podemos ver que antes de agregar el detalle el id tiene valor 0
		//System.out.println("DETALLE ANTES: " + pelicula.getDetalle());
		// insertando el detalle mapeado de la movie a la db
		detallesService.insert(pelicula.getDetalle());
		// una vez que spring jpa agrega el detalle a la db toma el id y lo mapea al detalle
		// de la pelicula en cuestion de forma automatica sin que tengamos que configurarlo
		//System.out.println("DETALLE DESPUES: " + pelicula.getDetalle());
		
		// guardando en la db
		peliculasService.insert(pelicula);
		
		System.out.println("Una pelicula se ha guardado:");
		System.out.println(pelicula);
		
		attributes.addFlashAttribute("message", "La pelicula ha sido guardada con exito");
		
		// si todo sale bien se redirige al user al listado
		return "redirect:/peliculas/index";
	}
	
	// editar una pelicula
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idPelicula,
			Model model) {
		// buscamos la pelicula con el id seleccionado
		Pelicula pelicula = this.peliculasService.searchById(idPelicula);
		// enviamos una pelicula debido a que la vista solicita una para rellenar el form
		// como no es una pelicula que se vaya a rellenar desde cero,
		// no es necesario poner un @ModelAttribute Pelicula pelicula
		model.addAttribute("pelicula", pelicula);
		model = this.addGenerosAndCalificaciones(model);
		
		// no necesitamos crear una nueva vista para editar una pelicula
		// tampoco necesitamos crear un postMapping para editar porque
		// spring reusa el de pelicula save de acuerdo a como esta en la view
		return "peliculas/formPelicula";
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
	
	private Model addGenerosAndCalificaciones(Model model) {
		List<String> generos = peliculasService.searchGenres();
		List<String> clasificaciones = peliculasService.searchPEGI();
		
		model.addAttribute("generos", generos);
		model.addAttribute("clasificaciones", clasificaciones);
		return model;
	}
}
