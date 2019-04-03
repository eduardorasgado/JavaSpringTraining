package com.eduardocode.app.service;

import org.springframework.stereotype.Service;

import com.eduardocode.app.model.Usuario;

@Service
public interface IUsuariosService{
	void insert(Usuario usuario);
}
