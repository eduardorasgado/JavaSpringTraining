package com.eduardocode.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.eduardocode.app.model.Perfil;
import com.eduardocode.app.repository.PerfilesRepository;

public class PerfilesServiceJPA implements IPerfilesService {

	@Autowired
	private PerfilesRepository perfilesRepository;
	
	@Override
	public void insert(Perfil perfil) {
		// TODO Auto-generated method stub
		
	}

}
