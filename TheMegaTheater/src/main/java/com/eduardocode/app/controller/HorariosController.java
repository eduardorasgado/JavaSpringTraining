package com.eduardocode.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eduardocode.app.model.Horario;
import com.eduardocode.app.model.Pelicula;
import com.eduardocode.app.service.IHorariosService;
import com.eduardocode.app.service.IPeliculasService;
import com.eduardocode.app.utils.Utility;

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
			RedirectAttributes attributes,
			BindingResult result) {
		// guardamos un horario en la base de datos
		if(result.hasErrors()) {
			for(var error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
				// si existe un error en el binding entonces se envia automaticamente
				return "redirect:/horarios/create";
			}
		}
		System.out.println("POST HORARIO SAVE");
		
		attributes.addFlashAttribute("message", 
				"Se ha agregado el horario con exito");
		
		return "redirect:/horarios/create";
	}
	
	@InitBinder
	private void horariosInitBinder(WebDataBinder binder) {
		// la fecha que viene del request tiene el formato dd-MM-yyyy
		// y tiene que formatearse
		var dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormatter, false));
	}
}
