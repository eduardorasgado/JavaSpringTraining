package com.eduardocode.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eduardocode.app.model.Contacto;
import com.eduardocode.app.service.IPeliculasService;

@Controller
@RequestMapping("/contacto")
public class ContactoController {
	
	@Autowired
	private IPeliculasService peliculaService;
	
	@GetMapping("/")
	public String showForm(@ModelAttribute("instanciaContacto") Contacto contacto, 
			Model model) {
		
		model.addAttribute("generosPelicula", peliculaService.searchGenres());
		
		return "formContacto";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("instanciaContacto") Contacto contacto,
			RedirectAttributes attributes){
		// se guarda en contacto
		System.out.println("[CREANDO UN NUEVO CONTACTO EN CONTROLLER]:");
		System.out.println(contacto);
		
		attributes.addFlashAttribute("message", contacto.getNombre()+
				", se han registrado tus preferencias con exito. Tenemos mucho para ti!");
		
		return "redirect:/contacto/";
	}
}
