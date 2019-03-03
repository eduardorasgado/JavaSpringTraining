package com.eduardocode.app.service;

import java.util.LinkedList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.eduardocode.app.model.Horario;

@Service
public class HorariosServiceImp implements IHorariosService{
	private List<Horario> horarios = null;
	
	public HorariosServiceImp() {
		horarios = new LinkedList<Horario>();
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
	
}
