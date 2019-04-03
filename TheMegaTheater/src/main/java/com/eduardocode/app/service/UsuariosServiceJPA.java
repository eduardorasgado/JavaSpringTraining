package com.eduardocode.app.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.eduardocode.app.model.Usuario;
import com.eduardocode.app.repository.UsuariosRepository;

public class UsuariosServiceJPA implements IUsuariosService {

	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@Override
	public void insert(Usuario usuario) {
		usuariosRepository.save(usuario);	
	}

}
