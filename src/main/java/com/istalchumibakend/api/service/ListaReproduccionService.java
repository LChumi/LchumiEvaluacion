package com.istalchumibakend.api.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.istalchumibakend.api.entity.ListaReproducion;


public interface ListaReproduccionService {

	public Iterable<ListaReproducion> findAll();
	public Page<ListaReproducion> findAll(Pageable pageable);
	public Optional<ListaReproducion> findById(Long id);
	public ListaReproducion save(ListaReproducion listaReproducion);
	public void deleteById(Long id);
}
