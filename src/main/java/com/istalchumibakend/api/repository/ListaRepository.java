package com.istalchumibakend.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.istalchumibakend.api.entity.ListaReproducion;

public interface ListaRepository extends CrudRepository<ListaReproducion, Long>{

	Page<ListaReproducion> findAll(Pageable pageable );
}
