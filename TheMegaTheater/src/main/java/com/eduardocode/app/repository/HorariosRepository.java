package com.eduardocode.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardocode.app.model.Horario;

@Repository
public interface HorariosRepository extends JpaRepository<Horario, Integer> {

}
