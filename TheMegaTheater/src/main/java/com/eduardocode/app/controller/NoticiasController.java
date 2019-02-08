package com.eduardocode.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// esta clase es un controlador
@Controller
/* especificamos la ruta del controller con requestmapping a nivel
 * de clase
 * todas las subrutas a nivel de metodo seran con get o postmapping 
 **/ 
@RequestMapping("/noticias")
public class NoticiasController {

	// mapping a nivel de metodo con get y post mapping
	@GetMapping("/create")
	public String create() {
		// creacion de una nueva noticia
		return "noticias/formNoticia";
	}
}
