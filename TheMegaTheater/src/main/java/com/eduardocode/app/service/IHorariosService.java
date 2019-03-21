package com.eduardocode.app.service;

import java.util.List;

import com.eduardocode.app.model.Horario;

public interface IHorariosService {
	
	List<Horario> getAll();
	
	void insert(Horario horario);
	
	void delete(int idHorario);
	
	List<String> getSalas();
	
	Horario searchById(int idHorario);
}
