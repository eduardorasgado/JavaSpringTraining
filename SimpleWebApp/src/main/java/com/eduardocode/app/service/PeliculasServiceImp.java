package com.eduardocode.app.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

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
		var formatter = new SimpleDateFormat("dd-MM-yyyy");
		
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
		
		for(var pelicula : listaPeliculas) {
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

}
