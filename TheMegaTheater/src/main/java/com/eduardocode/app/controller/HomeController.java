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
		var listaBanners = bannerService.getAll();
		
		model.addAttribute("listaBanners", listaBanners);
		
		// counter para el slider
		int[] sliderCount = new int[listaBanners.size()];
		for(int i = 1; i <= listaBanners.size();i++) {
			sliderCount[i-1] = i;
		}
		model.addAttribute("sliderCounter", sliderCount);
		
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
			model.addAttribute("titulo", pelicula.getTitulo());
			model.addAttribute("duracion", pelicula.getDuracion());
			model.addAttribute("clasificacion", pelicula.getClasificacion());
			model.addAttribute("imagen", pelicula.getImagen());
			model.addAttribute("genero", pelicula.getGenero());
			model.addAttribute("fechaEstreno", pelicula.getFechaEstreno());
			model.addAttribute("id", idPelicula);
			model.addAttribute("fechaBusqueda", fechaBusqueda);
			model.addAttribute("precio", 50);
		}
		return "detail";
	}
	
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
}
