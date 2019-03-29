package com.eduardocode.app.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardocode.app.model.Horario;

@Repository
public interface HorariosRepository extends JpaRepository<Horario, Integer> {
	// idPelicula se agrega como Pelicula_Id debido a que
	// de Horario estamos apuntando al atributo pelicula 
	// y del tipo de pelicula, es decir Pelicula se va a buscar el atributo id
	// SELECT * FROM `horarios` WHERE idPelicula = 1 AND fecha = '2017-10-25'
	List<Horario> findByPelicula_IdAndFechaOrderByHora(int idPelicula, Date fecha);
}
