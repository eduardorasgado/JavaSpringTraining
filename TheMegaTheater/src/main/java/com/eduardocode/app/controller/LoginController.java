package com.eduardocode.app.controller;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class LoginController {
	
	@GetMapping("/index")
	public String showDashboard(Authentication authentication, Model model) {
		// se carga despues de que el user es logueado
		// para esto configuramos el tag form-login en el tag http en security.xml
		
		//para tener el dato del nombre del usuario actualmente logueado
		String userName = authentication.getName();
		// conseguimos los roles del user
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		
		
		System.out.println("User:"+userName);
		
		// mandamos al modelo los roles del user logueado
		List<String> roles = new LinkedList<String>();
		for(GrantedAuthority authObject : authorities) {
			roles.add(authObject.getAuthority());
		}
		
		model.addAttribute("roles", roles);
		
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
