package com.eduardocode.app.service;

import java.util.List;
import java.util.Optional;

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
		return perfilesRepository.findAll();
	}

	@Override
	public Perfil searchById(int idPerfil) {
		Optional<Perfil> perfilContainer = perfilesRepository.findById(idPerfil);
		if(perfilContainer.isPresent()) {
			return perfilContainer.get();
		}
		return null;
	}

	@Override
	public void delete(int idPerfil) {
		perfilesRepository.deleteById(idPerfil);
		
	}

}
