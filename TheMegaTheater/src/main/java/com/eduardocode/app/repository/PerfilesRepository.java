package com.eduardocode.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardocode.app.model.Perfil;

@Repository
public interface PerfilesRepository extends JpaRepository<Perfil, Integer> {

}
