package com.eduardocode.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class LoginController {
	
	@GetMapping("/index")
	public String showDashboard() {
		// se carga despues de que el user es logueado
		// para esto configuramos el tag form-login en el tag http en security.xml
		return "admin";
	}
	
	@GetMapping("/logout")
	public String salir(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		
		// salir de la session actual
		logoutHandler.logout(request, null, null);
		return "redirect:/entrar";
	}
}
