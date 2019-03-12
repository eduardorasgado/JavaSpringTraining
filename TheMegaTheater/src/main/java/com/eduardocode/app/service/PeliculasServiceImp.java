package com.eduardocode.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eduardocode.app.model.Detalle;
import com.eduardocode.app.model.Pelicula;

// Implementacion del metodo abstracto en IPeliculasService

/* Notacion service: permite la autoinclusion de una instancia de
 * Esta clase de servicio en un controller en forma de inyeccion
 *  de dependencia*/
@Service
public class PeliculasServiceImp implements IPeliculasService{
	
	private List<Pelicula> listaPeliculas = null;
	
	PeliculasServiceImp(){
		System.out.println("INSTANCIA DE SERVICIO DE PELICULAS CREADA(SINGLETON)");
		// constructor
		// formateador de fechas
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			// generando una lista de peliculas
			listaPeliculas = new LinkedList<>();
			/*
			 * Por el momento lo agregamos por fuerza bruta, 
			 * */
			Pelicula p1 = new Pelicula();
			p1 = this.setDatatoPelicula(p1, 1, "El viaje de Chihiro", 124, "A",
					"Anime Aventura", formatter.parse("02-05-2017"), "cinema.png",
					"Activa");
			p1 = this.setDetalle(p1, 1, "Jimmy Jim", "Tom Cruise, Katherine Jones", "lorem ipsum dolor sit amet",
					"https://www.youtube.com/embed/bILE5BEyhdo");
			
			
			Pelicula p2 = new Pelicula();
			p2 = this.setDatatoPelicula(p2, 2, "La bella y la bestia", 132, "B",
					"Drama", formatter.parse("20-05-2017"), "bella.png", "Activa");
			p2 = this.setDetalle(p2, 2, "Jimmy Jim", "Tom Cruise, Katherine Jones", "lorem ipsum dolor sit amet",
					"https://www.youtube.com/embed/bILE5BEyhdo");
			
			Pelicula p3 = new Pelicula();
			p3 = this.setDatatoPelicula(p3, 3, "Contratiempo", 106, "A", "Accion",
					formatter.parse("28-03-2016"), "contratiempo.png", "Activa");
			p3 = this.setDetalle(p3, 3, "Jimmy Jim", "Tom Cruise, Katherine Jones", "lorem ipsum dolor sit amet",
					"https://www.youtube.com/embed/bILE5BEyhdo");
			
			Pelicula p4 = new Pelicula();
			p4 = this.setDatatoPelicula(p4, 4, "Kong", 154, "A", "Accion",
					formatter.parse("06-06-2017"), "kong.png", "Inactiva");
			p4 = this.setDetalle(p4, 4, "Jimmy Jim", "Tom Cruise, Katherine Jones", "lorem ipsum dolor sit amet",
					"https://www.youtube.com/embed/bILE5BEyhdo");
			
			Pelicula p5 = new Pelicula();
			p5 = this.setDatatoPelicula(p5, 5, "Life: Vida Inteligente", 122, "B", "Terror",
					formatter.parse("01-02-2016"), "estreno5.png", "Activa");
			p5 = this.setDetalle(p5, 5, "Jimmy Jim", "Tom Cruise, Katherine Jones", "lorem ipsum dolor sit amet",
					"https://www.youtube.com/embed/bILE5BEyhdo");
			
			// agregando los objetos a la lista
			listaPeliculas.add(p1);
			listaPeliculas.add(p2);
			listaPeliculas.add(p3);
			listaPeliculas.add(p4);
			listaPeliculas.add(p5);
			
		} catch(ParseException e) {
			// en caso de que exista un error en  el formato de fecha
			System.out.println("Error: "+e.getMessage());
		}
		// en caso de salir todo bien
	}

	@Override
	public List<Pelicula> getAll() {
		// Auto-generated method stub
		// regresa una lista de objectos de tipo Pelicula
		return listaPeliculas;
	}
	
	@Override
	public Pelicula searchById(int idMovie) {
		// Auto-generated method stub
		
		for(Pelicula pelicula : listaPeliculas) {
			if(pelicula.getId() == idMovie) {
				// si encuentra la pelicula con el id deseado
				return pelicula;
			}
		}
		// si no se encontro la pelicula
		return null;
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

	@Override
	public void insert(Pelicula pelicula) {
		// TODO Auto-generated method stub
		listaPeliculas.add(pelicula);
	}
	
	private Pelicula setDetalle(Pelicula p, int id, String director,
			String actores, String sinopsis, String trailer) {
		Detalle detalle = new Detalle();
		
		detalle.setId(id);
		detalle.setDirector(director);
		detalle.setActores(actores);
		detalle.setSinopsis(sinopsis);
		detalle.setTrailer(trailer);
		
		p.setDetalle(detalle);
		return p;
	}

	@Override
	public List<String> searchGenres() {
		List<String> generos = new LinkedList<String>();
		
		generos.add("Accion");
		generos.add("Aventura");
		generos.add("Clasicas");
		generos.add("Comedia Romantica");
		generos.add("Drama");
		generos.add("Terror");
		generos.add("Infantil");
		generos.add("Accion y Aventuras");
		generos.add("Romaticas");
		generos.add("Ciencia Ficcion");
		
		return generos;
	}

}
