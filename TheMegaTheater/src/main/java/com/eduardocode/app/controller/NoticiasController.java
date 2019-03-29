package com.eduardocode.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eduardocode.app.model.Noticia;
import com.eduardocode.app.service.INoticiasService;

// esta clase es un controlador
@Controller
/* especificamos la ruta del controller con requestmapping a nivel
 * de clase
 * todas las subrutas a nivel de metodo seran con get o postmapping 
 **/ 
@RequestMapping("/noticias")
public class NoticiasController {
	
	// Dependency injection del servicio de Noticias
	@Autowired
	private INoticiasService noticiasService;
	
	@GetMapping("/index")
	public String index(Model model, Pageable page) {
		Page<Noticia> noticias = noticiasService.getAll(page);
		
		model.addAttribute("noticias", noticias);
		//model.addAttribute("pageSize", pageSize);
		return "noticias/listNoticias";
	}

	// mapping a nivel de metodo con get y post mapping
	@GetMapping("/create")
	public String create() {
		// creacion de una nueva noticia
		return "noticias/formNoticia";
	}
	
	@PostMapping("/save")
	public String save(
			Noticia noticia) {
		// se guarda el form en un post
		noticiasService.insert(noticia);
		
		return "noticias/formNoticia";
	}
	
	// manejando un intento de recargar usando get
	@GetMapping("/save")
	public String save() {
		return "noticias/formNoticia";
	}
}
