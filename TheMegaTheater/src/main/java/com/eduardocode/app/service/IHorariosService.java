package com.eduardocode.app.service;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.eduardocode.app.model.Horario;

public interface IHorariosService {
	
	List<Horario> getAll();
	
	Page<Horario> getAll(Pageable page);
	
	void insert(Horario horario);
	
	void delete(int idHorario);
	
	List<String> getSalas();
	
	Horario searchById(int idHorario);
	
	List<Horario> searchByIdPelicula(int idPelicula, Date date);
}
