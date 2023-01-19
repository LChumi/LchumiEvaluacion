package com.istalchumibakend.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.istalchumibakend.api.entity.ListaReproducion;
import com.istalchumibakend.api.repository.ListaRepository;

@Service
public class ListaReproduccionServiceImpl  implements ListaReproduccionService{

	@Autowired
	private ListaRepository listaRepository;
	
	@Override
	@Transactional(readOnly=true)
	public Iterable<ListaReproducion> findAll(){
		return listaRepository.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Page<ListaReproducion> findAll(Pageable pageable) {
		return listaRepository.findAll(pageable);
	}

	@Override
	public Optional<ListaReproducion> findById(Long id) {
		return listaRepository.findById(id);
	}

	@Override
	public ListaReproducion save(ListaReproducion listaReproducion) {
		return listaRepository.save(listaReproducion);
	}

	@Override
	public void deleteById(Long id) {
		listaRepository.deleteById(id);
	}
}
