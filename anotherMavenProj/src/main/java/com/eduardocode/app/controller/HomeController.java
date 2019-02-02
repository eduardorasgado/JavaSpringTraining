package com.eduardocode.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// las directivas @ son agregadas de forma manual para
// poder usar la clase actual como un controlador
@Controller
public class HomeController {
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String index()
	{
		// retorna una vista en forma de string
		return "home";
	}
}
