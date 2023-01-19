package com.istalchumibakend.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.istalchumibakend.api.entity.Cancion;

public interface CancionService {
	
	public Iterable<Cancion> findAll();
	public Page<Cancion> findAll(Pageable pageable);
	public Optional<Cancion> findById(Long id);
	public Cancion save(Cancion cancion);
	public void deleteById(Long id);
	

}
