package com.istalchumibakend.api.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import com.istalchumibakend.api.entity.Cancion;

public interface CancionRepository extends CrudRepository<Cancion, Long>{
	
	Page<Cancion> findAll(Pageable pageable );

}
