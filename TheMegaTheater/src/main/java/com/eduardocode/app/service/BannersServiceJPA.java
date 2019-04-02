package com.eduardocode.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eduardocode.app.model.Banner;
import com.eduardocode.app.repository.BannersRepository;

@Service
public class BannersServiceJPA implements IBannersService{

	@Autowired
	private BannersRepository bannersRepository;
	
	@Override
	public List<Banner> getAll() {
		return bannersRepository.findAll();
	}
	
	@Override
	public Page<Banner> getAll(Pageable page) {
		return bannersRepository.findAll(page);
	}

	@Override
	public void insert(Banner banner) {
		bannersRepository.save(banner);
		
	}

	@Override
	public void delete(int idBanner) {
		bannersRepository.deleteById(idBanner);
	}

	@Override
	public Banner findById(int idBanner) {
		Optional<Banner> banner = bannersRepository.findById(idBanner);
		if(banner.isPresent()) {
			return banner.get();
		}
		return null;
	}

	@Override
	public List<Banner> getAllActive() {
		return bannersRepository.findByStatus("Activo");
	}
}
