package com.eduardocode.app.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.eduardocode.app.model.Banner;

public interface IBannersService {
	List<Banner> getAll();
	
	Page<Banner> getAll(Pageable page);
	
	List<Banner> getAllActive();
	
	Banner findById(int idBanner);
	
	void insert(Banner banner);
	
	void delete(int idBanner);
}
