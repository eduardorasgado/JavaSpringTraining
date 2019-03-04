package com.eduardocode.app.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.eduardocode.app.model.Noticia;

// esta interfaz se crea con ayuda del ide para extender de la interfaz
// CRUD repository de Spring Data, sustituimos los dos parametros de la interfaz
// generica por Noticia, Integer

@Repository // anotacion propia de spring, da de alta un bean en spring para un bean de dato
// podemos darle un nombre al bean repository en la anotacion de arriba
public interface NoticiasRepository extends CrudRepository<Noticia, Integer> {
	// Con esto podemos ya hacer automatico el CRUD de la tabla noticias
}
