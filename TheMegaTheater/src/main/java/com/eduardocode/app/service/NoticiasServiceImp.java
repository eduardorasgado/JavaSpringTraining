package com.eduardocode.app.service;

import org.springframework.stereotype.Service;

import com.eduardocode.app.model.Noticia;

@Service
public class NoticiasServiceImp implements INoticiasService {
	
	public NoticiasServiceImp() {
		System.out.println("INSTANCIA DE SERVICIO DE NOTICIAS CREADA(SINGLETON)");
	}

	@Override
	public void guardar(Noticia noticia) {
		System.out.println(noticia);
	}

}
