package com.eduardocode.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/banners")
public class BannerController {
	// metodo para desplegar el listado de los banners
	@GetMapping("/index")
	public String index() {
		return "banners/listBanners";
	}
	
	// metodo para la vista de creacion de banner
	@GetMapping("/create")
	public String create() {
		return "banners/formBanner";
	}
}
