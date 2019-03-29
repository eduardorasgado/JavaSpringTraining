package com.eduardocode.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eduardocode.app.model.Noticia;

@Service
public class NoticiasServiceJPA implements INoticiasService {

	@Override
	public List<Noticia> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Noticia> getAll(Pageable page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Noticia noticia) {
		// TODO Auto-generated method stub
		
	}
}
