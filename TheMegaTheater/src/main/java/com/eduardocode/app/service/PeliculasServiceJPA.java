package com.eduardocode.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardocode.app.model.Pelicula;
import com.eduardocode.app.repository.PeliculasRepository;

@Service
public class PeliculasServiceJPA implements IPeliculasService {
	
	@Autowired // inyeccion de la dependencia del repositorio
	private PeliculasRepository peliculasRepository;

	@Override
	public List<Pelicula> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pelicula searchById(int idMovie) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Pelicula pelicula) {
		// inserta en la base de datos
		peliculasRepository.save(pelicula);
		
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

	@Override
	public List<String> searchPEGI() {
		List<String> pegi = new LinkedList<String>();
		pegi.add("A");
		pegi.add("B");
		pegi.add("C");
		
		return pegi;
	}

}
