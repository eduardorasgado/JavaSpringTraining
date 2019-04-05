package com.eduardocode.app.service;

import java.util.List;

import com.eduardocode.app.model.Perfil;

public interface IPerfilesService {
	List<Perfil> getAll();
	
	void insert(Perfil perfil);
	
	Perfil searchById(int idPerfil);
	
	void delete(int idPerfil);
}
