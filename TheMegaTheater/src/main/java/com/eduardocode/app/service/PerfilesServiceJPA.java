package com.eduardocode.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardocode.app.model.Perfil;
import com.eduardocode.app.repository.PerfilesRepository;

@Service
public class PerfilesServiceJPA implements IPerfilesService {

	@Autowired
	private PerfilesRepository perfilesRepository;
	
	@Override
	public void insert(Perfil perfil) {
		perfilesRepository.save(perfil);
	}

	@Override
	public List<Perfil> getAll() {
		// TODO Auto-generated method stub
		return perfilesRepository.findAll();
	}

}
