package com.eduardocode.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eduardocode.app.model.Contacto;
import com.eduardocode.app.service.IPeliculasService;

@Controller
@RequestMapping("/contacto")
public class ContactoController {
	
	@Autowired
	private IPeliculasService peliculaService;
	
	@GetMapping("/")
	public String showForm(@ModelAttribute("instanciaContacto") Contacto contacto, Model model) {
		
		model.addAttribute("generosPelicula", peliculaService.searchGenres());
		
		return "formContacto";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("instanciaContacto") Contacto contacto){
		// se guarda en contacto
		System.out.println("[CREANDO UN NUEVO CONTACTO EN CONTROLLER]");
		return "home";
	}
}
