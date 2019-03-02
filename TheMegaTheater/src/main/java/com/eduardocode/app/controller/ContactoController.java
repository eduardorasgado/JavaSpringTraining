package com.eduardocode.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactoController {
	@GetMapping("/contacto")
	public String showForm() {
		return "formContacto";
	}
}
