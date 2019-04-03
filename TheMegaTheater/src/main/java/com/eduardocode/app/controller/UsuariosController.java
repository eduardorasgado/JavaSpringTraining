package com.eduardocode.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eduardocode.app.model.Usuario;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/create")
	public String create(@ModelAttribute Usuario usuario) {
		//
		return "auth/formRegister";
	}
	
	@GetMapping("/demo-bcript")
	public String encriptar() {
		//
		String password = "mari123";
		String password2 = "gabagabahey";
		
		String encriptacion = encoder.encode(password);
		String encriptacion2 = encoder.encode(password2);
		
		System.out.println("password: " + password);
		System.out.println("encriptacion: " + encriptacion);
		System.out.println("password 2: " + password2);
		System.out.println("encriptacion 2: " + encriptacion2);
		
		return "home";
	}
}
