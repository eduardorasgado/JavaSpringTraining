package com.eduardocode.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eduardocode.app.model.Horario;
import com.eduardocode.app.model.Pelicula;
import com.eduardocode.app.service.IHorariosService;
import com.eduardocode.app.service.IPeliculasService;

@Controller
@RequestMapping("/horarios")
public class HorariosController {
	
	@Autowired
	private IHorariosService horarioService;
	@Autowired
	private IPeliculasService peliculaService;
	
	@GetMapping("/index")
	public String index(Model model) {
		
		model.addAttribute("horarios", horarioService.getAll());
		
		return "horarios/listHorarios";
	}
	
	@GetMapping("/create")
	public String create(@ModelAttribute("instanciaHorario") Horario horario,
			Model model) {
		
		model.addAttribute("peliculas", peliculaService.getAll());
		// las salas se envian desde el metodo que implementa al anotacion modelattribute
		
		return "horarios/formHorario";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("instanciaHorario") Horario horario,
			RedirectAttributes attributes,
			Model model,
			BindingResult result) {
		// guardamos un horario en la base de datos
		
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			// si existe un error en el binding entonces se envia automaticamente
			model.addAttribute("peliculas", peliculaService.getAll());
			// el model attribute de las salas se agrega como metodo con anotacion
			
			// se vuelve a la misma pagina pero ahora con mensajes del binding result
			
			return "horarios/create";
		}
		System.out.println("POST HORARIO SAVED:");
		System.out.println(horario);
	
		//guardando el horario en la db
		horarioService.insert(horario);
		
		// de todo lo siguiente se encarga el jpa
		//Pelicula pelicula = peliculaService.searchById(horario.getPelicula().getId());
		//List<Horario> horariosList = pelicula.getHorarios();
		//horariosList.add(horario);
		//pelicula.setHorarios(horariosList);
		//peliculaService.insert(pelicula);
		
		
		attributes.addFlashAttribute("message", 
				"Se ha agregado el horario con exito");
		
		return "redirect:/horarios/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(Model model,
			@PathVariable("id") int idHorario) {
		// regresando el modelo de la instancia ya guardada a la vista para editarla
		Horario horario = horarioService.searchById(idHorario);
		model.addAttribute("instanciaHorario", horario);
		// buscando las peliculas para renderearlas
		List<Pelicula> peliculas = peliculaService.getAll();
		
		model.addAttribute("peliculas", peliculas);
		return "horarios/formHorario";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int idHorario,
			RedirectAttributes attributes) {
		
		//
		
		attributes.addFlashAttribute("message", "Se ha eliminado el horario");
		return "redirect:/horarios/index";
	}
	
	// utilidades
	@ModelAttribute("horarioSalas")
	public List<String> getSalas() {
		List<String> salas = horarioService.getSalas();
		return salas;
	}
	
	@InitBinder
	private void horariosInitBinder(WebDataBinder binder) {
		// la fecha que viene del request tiene el formato dd-MM-yyyy
		// y tiene que formatearse
		SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormatter, false));
	}
}
