package com.eduardocode.app.service;

import java.util.List;

import com.eduardocode.app.model.Contacto;

public interface IContactosService {
	List<String> getTiposNotificaciones();
	void insert(Contacto contacto);
}
