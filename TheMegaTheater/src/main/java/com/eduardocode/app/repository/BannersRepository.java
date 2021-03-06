package com.eduardocode.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eduardocode.app.model.Banner;

@Repository
public interface BannersRepository extends JpaRepository<Banner, Integer> {

	List<Banner> findByStatus(String status);
}
