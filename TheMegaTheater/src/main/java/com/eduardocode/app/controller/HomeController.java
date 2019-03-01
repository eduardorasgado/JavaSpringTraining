package com.eduardocode.app.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.eduardocode.app.service.IBannersService;
//import com.eduardocode.app.model.Pelicula;
import com.eduardocode.app.service.IPeliculasService;
import com.eduardocode.app.utils.Utility;

@Controller
public class HomeController {
	/* instanciando una clase del servicio peliculas usando autowire
	 * que permite la inyeccion de dependencias
	 *  Aqui vemos como en ningun momento usamos el operador new para instanciar
	 *  porque spring lo hace por si solo para optimizar procesos*/
	@Autowired
	private IPeliculasService servicePeliculas;
	
	@Autowired
	private IBannersService bannerService;
	
	private SimpleDateFormat homeDateFormatter = new SimpleDateFormat("dd-M-yyyy");
	
	//@RequestMapping(value="/home", method=RequestMethod.GET)
	@GetMapping("/home")
	public String index(Model model) {
		return this.showMain(model);
	}
	
	//@RequestMapping(value="/search", method=RequestMethod.POST)
	@PostMapping("/search")
	public String searchByDate(Model model,
			@RequestParam("fecha") String fecha) {

		// ahora la fecha actual va a ser la fecha pasada en el search
		model = this.getMoviesAboutDate(model, fecha);

		model = this.getBanners(model);
		
		return "home";
	}

	@GetMapping("/search")
	// Manejando la peticion get de /search
	public String searchByDate(Model model) {
		return this.showMain(model);
	}
	
	@GetMapping("/")
	public String showMain(Model model) {
		var fechaBusqueda = homeDateFormatter.format(new Date());
		model = this.getMoviesAboutDate(model, fechaBusqueda);
		
		// agregando banners al modelo
		model = this.getBanners(model);
		
		return "home";		
	}
	
	@RequestMapping(value="/detail/{id}/{fecha}", method=RequestMethod.GET)
	public String showDetail(Model model,
			@PathVariable("id") int idPelicula,
			@PathVariable("fecha") String fechaBusqueda) {
		
		// llamando a un metodo del servicio de peliculas
		var pelicula = servicePeliculas.searchById(idPelicula);
		
		if(pelicula == null) {
			// en caso de no existir el id
			model.addAttribute("Error", true);
		} else {
			model.addAttribute("pelicula", pelicula);
			model.addAttribute("fechaBusqueda", fechaBusqueda);
			model.addAttribute("precio", 50);
		}
		return "detail";
	}
	
	// utilidades
	
	private Model getMoviesAboutDate(Model model, 
			String fechaBusqueda) {
		// sintaxis java 10
		// llenando la lista con el modelo
		var peliculas = servicePeliculas.getAll();
		
		// creando la lista de 5 dias a partir de ahorita
		var siguientesDias = Utility.generateNextDays(4);
		
		// mandando la lista al frontend
		model.addAttribute("peliculas", peliculas);
		// mandando la fecha actual al frontend y los sig 4 dias
		model.addAttribute("fechaBusqueda", fechaBusqueda);
		model.addAttribute("listaFechas", siguientesDias);
		
		return model;
	}
	
	private Model getBanners(Model model) {
		// agregando banners al modelo
		var listaBanners = bannerService.getAll();
						
		model.addAttribute("listaBanners", listaBanners);
		
		// tomar el id del primer elemento como punto de inicio o cero
		if(listaBanners.size() > 0) {
			var initPoint = listaBanners.get(0).getId();
			
			// counter para el slider
			int[] sliderCount = new int[listaBanners.size()];
			for(int i = 0; i < listaBanners.size();i++) {
				sliderCount[i] = i;
			}
			model.addAttribute("sliderCounter", sliderCount);
			// para mostrar los sliders en orden aun cuando no inicien con un id de
			// cero, crear las condiciones para que se considere cero
			model.addAttribute("bannerinit", initPoint);
		}
		return model;
	}
}
