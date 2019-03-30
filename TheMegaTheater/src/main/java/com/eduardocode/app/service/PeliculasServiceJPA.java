package com.eduardocode.app.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eduardocode.app.model.Pelicula;
import com.eduardocode.app.repository.HorariosRepository;
import com.eduardocode.app.repository.PeliculasRepository;

@Service
public class PeliculasServiceJPA implements IPeliculasService {
	
	@Autowired // inyeccion de la dependencia del repositorio
	private PeliculasRepository peliculasRepository;
	
	@Autowired HorariosRepository horariosRepository;
	
	@Override // paginacion
	public List<Pelicula> getAll() {
		//return peliculasRepository.findAll();
		return peliculasRepository.findAll();
	}

	@Override // paginacion
	public Page<Pelicula> getAll(Pageable page) {
		//return peliculasRepository.findAll();
		return peliculasRepository.findAll(page);
	}
	
	@Override
	public List<Pelicula> getAllActive() {
		return peliculasRepository.findByStatus("Activa");
		
	}

	@Override
	public Pelicula searchById(int idMovie) {
		Optional<Pelicula> peliculaContainer = peliculasRepository.findById(idMovie);
		if (peliculaContainer.isPresent()) {
			return peliculaContainer.get();
		}
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

	@Override
	public void delete(int idMovie) {
		peliculasRepository.deleteById(idMovie);		
	}
}
