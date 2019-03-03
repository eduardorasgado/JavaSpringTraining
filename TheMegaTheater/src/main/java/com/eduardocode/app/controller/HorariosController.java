package com.eduardocode.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eduardocode.app.model.Horario;
import com.eduardocode.app.service.IHorariosService;
import com.eduardocode.app.service.IPeliculasService;

@Controller
@RequestMapping("/horarios")
public class HorariosController {
	
	@Autowired
	private IHorariosService horarioService;
	@Autowired
	private IPeliculasService peliculaService;
	
	@GetMapping("/index")
	public String index(Model model) {
		
		model.addAttribute("horarios", horarioService.getAll());
		
		return "horarios/listHorarios";
	}
	
	@GetMapping("/create")
	public String create(@ModelAttribute("instanciaHorario") Horario horario,
			Model model) {
		
		model.addAttribute("peliculas", peliculaService.getAll());
		model.addAttribute("horarioSalas", horarioService.getSalas());
		
		return "horarios/formHorario";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("instanciaHorario") Horario horario,
			RedirectAttributes attributes) {
		// guardamos un horario en la base de datos
		System.out.println("POST HORARIO SAVE");
		
		attributes.addFlashAttribute("message", 
				"Se ha agregado el horario con exito");
		
		return "redirect:/horarios/create";
	}
}
