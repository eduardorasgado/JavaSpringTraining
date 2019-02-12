package com.eduardocode.app.service;

import org.springframework.stereotype.Service;

import com.eduardocode.app.model.Noticia;

@Service
public class NoticiasServiceImp implements INoticiasService {

	@Override
	public void guardar(Noticia noticia) {
		System.out.println(noticia);
	}

}
