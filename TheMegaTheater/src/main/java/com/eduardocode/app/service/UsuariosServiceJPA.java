package com.eduardocode.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eduardocode.app.model.Usuario;
import com.eduardocode.app.repository.UsuariosRepository;

@Service
public class UsuariosServiceJPA implements IUsuariosService {

	@Autowired
	private UsuariosRepository usuariosRepository;
	
	@Override
	public void insert(Usuario usuario) {
		usuariosRepository.save(usuario);	
	}

	@Override
	public List<Usuario> getAll() {
		List<Usuario> usuarios = usuariosRepository.findAll();
		return usuarios;
	}

	@Override
	public Page<Usuario> getAll(Pageable page) {
		Page<Usuario> usuarios = usuariosRepository.findAll(page);
		return usuarios;
	}

}
