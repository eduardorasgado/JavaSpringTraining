package com.eduardocode.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/horarios")
public class HorariosController {
	
	@GetMapping("/index")
	public String index() {
		
		return "horarios/listHorarios";
	}
	
	@GetMapping("/create")
	public String create() {
		
		return "horarios/formHorario";
	}
}
