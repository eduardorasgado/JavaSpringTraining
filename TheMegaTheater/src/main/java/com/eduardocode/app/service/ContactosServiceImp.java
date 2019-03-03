package com.eduardocode.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ContactosServiceImp implements IContactosService{

	List<String> tipos = null;
	
	public ContactosServiceImp() {
		tipos = new LinkedList<>();
		this.setTiposNotificaciones();
	}
	
	@Override
	public List<String> getTiposNotificaciones() {	
		return tipos;
	}
	
	private void setTiposNotificaciones() {
		tipos.add("Estrenos");
		tipos.add("Promociones");
		tipos.add("Noticias");
		tipos.add("Preventas");
	}

}
