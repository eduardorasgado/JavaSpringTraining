package com.eduardocode.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eduardocode.app.model.Contacto;

@Service
public class ContactosServiceImp implements IContactosService{

	private List<String> tipos = null;
	private List<Contacto> contactos = null;
	
	public ContactosServiceImp() {
		System.out.println("INSTANCIA DE SERVICIO DE CONTACTO CREADA(SINGLETON)");
		contactos = new LinkedList<>();
		
		tipos = new LinkedList<>();
		this.setTiposNotificaciones();
	}
	
	@Override
	public List<String> getTiposNotificaciones() {	
		return tipos;
	}

	@Override
	public void insert(Contacto contacto) {
		contactos.add(contacto);
		
	}
	
	private void setTiposNotificaciones() {
		tipos.add("Estrenos");
		tipos.add("Promociones");
		tipos.add("Noticias");
		tipos.add("Preventas");
	}
}
