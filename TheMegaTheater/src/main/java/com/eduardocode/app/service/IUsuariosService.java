package com.eduardocode.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.eduardocode.app.model.Usuario;

public interface IUsuariosService{
	List<Usuario> getAll();
	
	Page<Usuario> getAll(Pageable page);
	
	void insert(Usuario usuario);
	
	Usuario searchById(int idUsuario);
	
	void delete(int idUsuario);
}
