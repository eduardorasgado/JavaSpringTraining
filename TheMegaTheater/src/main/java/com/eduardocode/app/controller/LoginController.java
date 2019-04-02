package com.eduardocode.app.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class LoginController {
	
	@GetMapping("/entrar")
	public String entrar() {
		// metodo para devolver el formulario personalizado del login
		// Se configura su llamado en security.xml dentro del tag html
		return "auth/formLogin";
	}
	
	/*
	 * Para el logueo de usuario se manda el form a traves del metodo entrar anterior
	 * En el caso de procesar los datos adquiridos, spring security lo hace automaticamente
	 * siempre en la ruta /login
	 * En caso de haber error en los datos del logueo spring devolvera un parametro de error en la url
	 * */
	
	@GetMapping("/logout")
	public String salir(HttpServletRequest request) {
		SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		
		// salir de la session actual
		logoutHandler.logout(request, null, null);
		return "redirect:/admin/entrar";
	}
}
