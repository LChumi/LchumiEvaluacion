package com.istalchumibakend.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.istalchumibakend.api.entity.Cancion;
import com.istalchumibakend.api.repository.CancionRepository;

@Service
public class CancionSericeImpl implements CancionService{
	
	@Autowired
	private CancionRepository cancionRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<Cancion> findAll(){
		return cancionRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<Cancion> findAll(Pageable pageable) {
		return cancionRepository.findAll(pageable);
	}

	@Override
	public Optional<Cancion> findById(Long id) {
		return cancionRepository.findById(id);
	}

	@Override
	public Cancion save(Cancion cancion) {
		return cancionRepository.save(cancion);
	}

	@Override
	public void deleteById(Long id) {
		cancionRepository.deleteById(id);
	}
	

}
