package com.eduardocode.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String index() {
		return "home";
	}
	
	
	@RequestMapping(value="/detail", method=RequestMethod.GET)
	public String showDetail(Model model) {
		
		String tituloPelicula = "El Imaginario del Dr Parnasus";
		int duracion = 135;
		double precioEntrada = 120;
		String desc = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. "
				+ "Ut pellentesque libero id vehicula facilisis. Nullam blandit et "
				+ "felis in interdum. Mauris cursus eros quis nibh faucibus condimentum. ";
		
		// pasando datos al frontend
		model.addAttribute("titulo", tituloPelicula);
		model.addAttribute("duracion", duracion);
		model.addAttribute("precio", precioEntrada);
		model.addAttribute("descripcion", desc);
		
		return "detail";
	}
}
