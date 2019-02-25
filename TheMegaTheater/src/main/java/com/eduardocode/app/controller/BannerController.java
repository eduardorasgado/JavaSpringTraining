package com.eduardocode.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eduardocode.app.model.Banner;
import com.eduardocode.app.service.IBannersService;

@Controller
@RequestMapping("/banners")
public class BannerController {
	@Autowired
	private IBannersService bannersService;
	
	// metodo para desplegar el listado de los banners
	@GetMapping("/index")
	public String showindex(Model model) {
		// retorna la lista con los datos de cada banner
		// llamamos a todos los banners disponibles
		List<Banner> listaBanners = bannersService.getAll();
		
		model.addAttribute("listaBanners", listaBanners);
		
		return "banners/listBanners";
	}
	
	// metodo para la vista de creacion de banner
	@GetMapping("/create")
	public String create() {
		return "banners/formBanner";
	}
	
	@PostMapping("/save")
	// explicacion de los parametros en el controlador de peliculas
	public String save(Banner banner, RedirectAttributes attribute,
			@RequestParam("archivoImagen") MultipartFile imagen,
			HttpServletRequest request, BindingResult result) {
		//
		return null;
	}
}
