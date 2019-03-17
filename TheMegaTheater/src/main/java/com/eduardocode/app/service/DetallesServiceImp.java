package com.eduardocode.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardocode.app.model.Detalle;
import com.eduardocode.app.repository.DetallesRepository;

@Service
public class DetallesServiceImp implements IDetallesServiceJPA {

	@Autowired
	private DetallesRepository detallesRepository;
	
	@Override
	public void insert(Detalle detalle) {
		detallesRepository.save(detalle);		
	}

}
