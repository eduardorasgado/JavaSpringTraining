package com.eduardocode.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.eduardocode.app.model.Noticia;

public interface INoticiasService {
	
	List<Noticia> getAll();
	
	Page<Noticia> getAll(Pageable page);
	
	void insert(Noticia noticia);
	
	Noticia searchById(int idNoticia);
}
