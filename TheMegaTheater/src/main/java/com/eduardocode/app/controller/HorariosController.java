package com.eduardocode.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
	public String create(Model model) {
		
		model.addAttribute("peliculas", peliculaService.getAll());
		
		return "horarios/formHorario";
	}
}
