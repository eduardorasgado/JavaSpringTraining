package com.eduardocode.app.service;

import java.util.List;

import com.eduardocode.app.model.Pelicula;

public interface IPeliculasService {
	
	List<Pelicula> getAll();
	
	Pelicula searchById(int idMovie);
	
	void insert(Pelicula pelicula);
	
	void delete(int idMovie);
	
	List<String> searchGenres();
	
	List<String> searchPEGI();
}
