package com.eduardocode.app.service;

import java.util.List;

import com.eduardocode.app.model.Banner;

public interface IBannersService {
	List<Banner> getAll();
	
	void insert(Banner banner);
	
	void delete(int idBanner);
}
