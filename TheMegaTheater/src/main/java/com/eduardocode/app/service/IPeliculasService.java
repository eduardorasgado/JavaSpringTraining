package com.eduardocode.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.eduardocode.app.model.Pelicula;

public interface IPeliculasService {
	
	List<Pelicula> getAll();
	
	Page<Pelicula> getAll(Pageable page);
	
	Pelicula searchById(int idMovie);
	
	void insert(Pelicula pelicula);
	
	void delete(int idMovie);
	
	List<String> searchGenres();
	
	List<String> searchPEGI();
	
}
