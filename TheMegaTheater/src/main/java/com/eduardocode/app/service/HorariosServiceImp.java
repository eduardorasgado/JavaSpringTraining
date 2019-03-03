package com.eduardocode.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eduardocode.app.model.Horario;

@Service
public class HorariosServiceImp implements IHorariosService{
	private List<Horario> horarios = null;
	private List<String> salas = null;
	
	public HorariosServiceImp() {
		horarios = new LinkedList<Horario>();
		this.initializeSalas();
	}

	@Override
	public List<Horario> getAll() {
		// TODO Auto-generated method stub
		return horarios;
	}

	@Override
	public void insert(Horario horario) {
		// TODO Auto-generated method stub
		horarios.add(horario);
	}

	@Override
	public List<String> getSalas() {
		// TODO Auto-generated method stub
		return salas;
	}
	
	private void initializeSalas() {
		salas = new LinkedList<>();
		
		salas.add("Premium");
		salas.add("Sala 1");
		salas.add("Sala 2");
		salas.add("Sala 3");
	}
	
}
