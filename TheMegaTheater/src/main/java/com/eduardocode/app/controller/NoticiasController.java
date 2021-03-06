package com.eduardocode.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
		int pageSize = noticias.getTotalPages();
		
		model.addAttribute("noticias", noticias);
		model.addAttribute("pageSize", pageSize);
		
		return "noticias/listNoticias";
	}

	// mapping a nivel de metodo con get y post mapping
	@GetMapping("/create")
	public String create(@ModelAttribute Noticia noticia) {
		// creacion de una nueva noticia
		return "noticias/formNoticia";
	}
	
	@PostMapping("/save")
	public String save(
			@ModelAttribute Noticia noticia,
			RedirectAttributes attributes) {
		// se guarda el form en un post
		noticiasService.insert(noticia);
		
		attributes.addFlashAttribute("message", "Se ha agreagado una nueva noticia con exito");
		return "redirect:/noticias/index?page=0";
	}
	
	// manejando un intento de recargar usando get
	@GetMapping("/save")
	public String save() {
		return "noticias/formNoticia";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int idNoticia,
			Model model) {
		Noticia noticia = noticiasService.searchById(idNoticia);
		if(noticia == null) {
			// error 404
			return "errors/404";
		}
		// retornar la vista para editar pero con la noticia
		model.addAttribute("noticia", noticia);
		
		return "noticias/formNoticia";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable("id") int idNoticia,
			RedirectAttributes attributes) {
		
		Noticia noticia = noticiasService.searchById(idNoticia);
		noticiasService.delete(noticia);
		
		attributes.addFlashAttribute("error", "Se ha eliminado una noticia");
		
		return "redirect:/noticias/index?page=0";
	}
}
