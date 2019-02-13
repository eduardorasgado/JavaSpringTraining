package com.eduardocode.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eduardocode.app.model.Pelicula;

@Controller
@RequestMapping("/peliculas")
public class PeliculasController {

	@GetMapping("/create")
	public String create() {
		return "peliculas/formPelicula";
	}
	
	@PostMapping("/save")
	public String save(Pelicula pelicula,
			// con BindingResult podemos obtener posibles errores en el
			// data binding
			BindingResult result) {
		
		// manejando los errores con el binding result
		if(result.hasErrors()) {
			// solo retornamos la vista
			for(var error : result.getAllErrors()) {
				// imprimiendo cada uno de los posibles errores
				System.out.println(error.getDefaultMessage());
			}
			return "peliculas/formPelicula";
		}
		System.out.println("Una pelicula se ha guardado:");
		System.out.println(pelicula);
		
		return "peliculas/formPelicula";
	}
	
	// uitilidades
	
	// anotacion init binder -> personalizar data binding
	// dada la anotacion initbinder esta sera autodetectada una vez creada 
	// la funcion y anotada
	@InitBinder
	private void peliculaInitBinder(WebDataBinder binder) {
		var dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		// ultimo false no permitira fechas vacias
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(dateFormatter, false)); 
	}
	
}
