package com.eduardocode.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eduardocode.app.model.Detalle;
import com.eduardocode.app.repository.DetallesRepository;

@Service
public class DetallesServiceJPA implements IDetallesService {

	@Autowired
	private DetallesRepository detallesRepository;
	
	@Override
	public void insert(Detalle detalle) {
		detallesRepository.save(detalle);		
	}

	@Override
	public void delete(int idDetalle) {
		detallesRepository.deleteById(idDetalle);		
	}

}
