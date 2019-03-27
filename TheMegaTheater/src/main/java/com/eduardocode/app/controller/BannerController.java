package com.eduardocode.app.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.eduardocode.app.model.Banner;
import com.eduardocode.app.service.IBannersService;
import com.eduardocode.app.utils.Utility;

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
	public String create(@ModelAttribute Banner banner) {
		return "banners/formBanner";
	}
	
	@PostMapping("/save")
	// explicacion de los parametros en el controlador de peliculas
	public String save(@ModelAttribute Banner banner, 
			RedirectAttributes attribute,
			@RequestParam("archivoImagen") MultipartFile imagen,
			HttpServletRequest request, BindingResult result) {
		// manejo de errores
		if(result.hasErrors()) {
			for(ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			// retornar a la misma vista del form
			// si hay errores los mensajes de eror se manda  automaticamente
			return "banners/formBanner";
		}
		
		// procesar la imagen
		if(!imagen.isEmpty()) {
			// obtener el nombre de la imagen al mismo tiempo que
			// guardamos la imagen y procesamos su nombre y ruta completa
			String nombreImagen = Utility.guardarImagen(imagen, request);
			banner.setNombreArchivo(nombreImagen);
		}
		
		// insertando el objeto banner en la base de datos
		bannersService.insert(banner);
		
		// redireccionar la pagina con un mensaje de exito
		attribute.addFlashAttribute("message", "El banner se ha guardado con exito");
		return "redirect:/banners/index";
	}
	
	@GetMapping("/edit/{id}")
	public String update(@PathVariable("id") int idBanner,
			Model model) {
		Banner banner = bannersService.findById(idBanner);
		model.addAttribute("banner", banner);
		
		return "banners/formBanner";
	}
	
	@GetMapping("delete/{id}")
	public String delete(@PathVariable("id") int idBanner,
			RedirectAttributes attributes) {
		bannersService.delete(idBanner);
		
		attributes.addFlashAttribute("message", "El banner ha sido eliminado");
		// redireccionamiento a la lista 
		return "redirect:/banners/index";
	}
}
