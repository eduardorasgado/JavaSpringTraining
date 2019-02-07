package com.eduardocode.app.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.eduardocode.app.model.Pelicula;

@Controller
public class HomeController {
	
	private SimpleDateFormat homeDateFormatter = new SimpleDateFormat("dd-M-yyyy");
	
	@RequestMapping(value="/home", method=RequestMethod.GET)
	public String index() {
		return "home";
	}
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String showMain(Model model) {
		// sintaxis java 10
		// llenando la lista con el modelo
		var peliculas = this.getMovieList();
		
		// mandando la lista al frontend
		model.addAttribute("peliculas", peliculas);
		// mandando la fecha actual al frontend
		model.addAttribute("fechaBusqueda", homeDateFormatter.format(new Date()));
		return "home";		
	}
	
	@RequestMapping(value="/detail/{id}/{fecha}", 
			method=RequestMethod.GET)
	public String showDetail(Model model,
			@PathVariable("id") int idPelicula,
			@PathVariable("fecha") String fechaBusqueda) {
		
		var listaPeliculas = this.getMovieList();
		
		boolean found = false;
		
		for(var pelicula : listaPeliculas) {
			if(pelicula.getId() == idPelicula) {
				// pasando datos al frontend
				model.addAttribute("titulo", pelicula.getTitulo());
				model.addAttribute("duracion", pelicula.getDuracion());
				model.addAttribute("clasificacion", pelicula.getClasificacion());
				model.addAttribute("id", idPelicula);
				//model.addAttribute("fechaBusqueda", homeDateFormatter.format(fechaBusqueda));
				model.addAttribute("fecha", fechaBusqueda);
				model.addAttribute("precio", 50);
				found = true;
			}
		}
		if(!found) {
			// en caso de no existir el id
			model.addAttribute("Error", true);
		}
		
		return "detail";
	}
	
	// metodo para generar la lista de peliculas que existirian en la db
	private List<Pelicula> getMovieList(){
		// formateador de fechas
		var formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		// en caso de que falle la creacion no hayan fugas de memoria?
		List<Pelicula> listaPeliculas = null;
		try {
			// generando una lista de peliculas
			listaPeliculas = new LinkedList<>();
			
			/*
			 * Por el momento lo agregamos por fuerza bruta, 
			 * */
			var p1 = new Pelicula();
			p1 = this.setDatatoPelicula(p1, 1, "El viaje de Chihiro", 124, "A",
					"Anime Aventura", formatter.parse("02-05-2017"), "cinema.png",
					"Activa");
			
			
			var p2 = new Pelicula();
			p2 = this.setDatatoPelicula(p2, 2, "La bella y la bestia", 132, "B",
					"Drama", formatter.parse("20-05-2017"), "bella.png", "Activa");
			
			
			var p3 = new Pelicula();
			p3 = this.setDatatoPelicula(p3, 3, "Contratiempo", 106, "A", "Accion",
					formatter.parse("28-03-2016"), "contratiempo.png", "Activa");
			
			var p4 = new Pelicula();
			p4 = this.setDatatoPelicula(p4, 4, "Kong", 154, "A", "Accion",
					formatter.parse("06-06-2017"), "kong.png", "Inactiva");
			
			var p5 = new Pelicula();
			p5 = this.setDatatoPelicula(p5, 5, "Life: Vida Inteligente", 122, "B", "Terror",
					formatter.parse("01-02-2016"), "estreno5.png", "Activa");
			
			// agregando los objetos a la lista
			listaPeliculas.add(p1);
			listaPeliculas.add(p2);
			listaPeliculas.add(p3);
			listaPeliculas.add(p4);
			listaPeliculas.add(p5);
			
		} catch(ParseException e) {
			// en caso de que exista un error en  el formato de fecha
			System.out.println("Error: "+e.getMessage());
			return null;
		}
		// en caso de salir todo bien
		return listaPeliculas;
	}
	
	private Pelicula setDatatoPelicula(Pelicula p, int id,
			String title, int length, String classification,
			String genre, Date premiere, String image, String status) {
		p.setId(id);
		p.setTitulo(title);
		p.setDuracion(length);
		p.setClasificacion(classification);
		p.setGenero(genre);
		p.setFechaEstreno(premiere);
		p.setImagen(image);
		p.setStatus(status);
		
		return p;
	}
}
