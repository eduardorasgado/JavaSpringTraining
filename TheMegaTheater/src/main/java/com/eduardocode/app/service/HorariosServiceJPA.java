package com.eduardocode.app.service;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eduardocode.app.model.Horario;
import com.eduardocode.app.repository.HorariosRepository;

@Service
public class HorariosServiceJPA implements IHorariosService{
	
	// servicio jpa para horario
	@Autowired
	private HorariosRepository horariosRepository;
	
	private List<String> salas = null;
	
	public HorariosServiceJPA() {
		this.initializeSalas();
	}

	@Override
	public List<Horario> getAll() {
		return horariosRepository.findAll();
	}
	
	@Override
	public Page<Horario> getAll(Pageable page) {
		return horariosRepository.findAll(page);
	}

	@Override
	public void insert(Horario horario) {
		// TODO Auto-generated method stub
		horariosRepository.save(horario);
	}

	@Override
	public List<String> getSalas() {
		return salas;
	}
	
	private void initializeSalas() {
		salas = new LinkedList<>();
		
		salas.add("Premium");
		salas.add("Sala 1");
		salas.add("Sala 2");
		salas.add("Sala 3");
	}

	@Override
	public Horario searchById(int idHorario) {
		// TODO Auto-generated method stub
		Optional<Horario> horario = horariosRepository.findById(idHorario);
		if(horario.isPresent()) {
			return horario.get();
		}
		return null;
		
	}

	@Override
	public void delete(int idHorario) {
		horariosRepository.deleteById(idHorario);		
	}

	@Override
	public List<Horario> searchByIdPeliculaAndFecha(int idPelicula, Date date) {
		return horariosRepository.findByPelicula_IdAndFechaOrderByHora(idPelicula, date);
	}
	
}
