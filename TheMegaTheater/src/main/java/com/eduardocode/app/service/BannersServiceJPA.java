package com.eduardocode.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	public void insert(Banner banner) {
		bannersRepository.save(banner);
		
	}

	@Override
	public void delete(int idBanner) {
		bannersRepository.deleteById(idBanner);
	}

}
