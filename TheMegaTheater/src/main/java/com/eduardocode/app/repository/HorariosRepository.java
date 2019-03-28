package com.eduardocode.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardocode.app.model.Horario;

@Repository
public interface HorariosRepository extends JpaRepository<Horario, Integer> {
	// idPelicula se agrega como Pelicula_Id
	List<Horario> findByPelicula_IdAndFechaOrderByHora(int idPelicula, Date fecha);
}
