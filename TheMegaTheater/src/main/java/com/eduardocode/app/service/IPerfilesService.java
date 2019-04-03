package com.eduardocode.app.service;

import org.springframework.stereotype.Service;

import com.eduardocode.app.model.Perfil;

@Service
public interface IPerfilesService {
	void insert(Perfil perfil);
}
