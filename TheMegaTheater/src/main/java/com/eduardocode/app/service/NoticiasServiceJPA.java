package com.eduardocode.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.eduardocode.app.model.Noticia;
import com.eduardocode.app.repository.NoticiasRepository;

@Service
public class NoticiasServiceJPA implements INoticiasService {

	@Autowired
	private NoticiasRepository noticiasRepository;
	
	@Override
	public List<Noticia> getAll() {
		return noticiasRepository.findAll();
	}

	@Override
	public Page<Noticia> getAll(Pageable page) {
		return noticiasRepository.findAll(page);
	}

	@Override
	public void insert(Noticia noticia) {
		noticiasRepository.save(noticia);
	}

	@Override
	public Noticia searchById(int idNoticia) {
		Optional<Noticia> noticiaContainer = noticiasRepository.findById(idNoticia);
		if(noticiaContainer.isPresent()) {
			return noticiaContainer.get();
		}
		return null;
	}

	@Override
	public void delete(Noticia noticia) {
		noticiasRepository.delete(noticia);
	}
}
