package com.eduardocode.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eduardocode.app.model.Contacto;

@Controller
@RequestMapping("/contacto")
public class ContactoController {
	
	@GetMapping("/")
	public String showForm(@ModelAttribute Contacto contacto) {
		return "formContacto";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute Contacto contacto){
		// se guarda en contacto
		System.out.println("[CREANDO UN NUEVO CONTACTO EN CONTROLLER]");
		return null;
	}
}
