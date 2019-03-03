package com.eduardocode.app.service;

import java.util.List;

import com.eduardocode.app.model.Horario;

public interface IHorariosService {
	
	List<Horario> getAll();
	
	void insert(Horario horario);
	
	List<String> getSalas();
}
