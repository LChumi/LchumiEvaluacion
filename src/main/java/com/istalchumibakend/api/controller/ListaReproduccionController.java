package com.istalchumibakend.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.istalchumibakend.api.entity.ListaReproducion;
import com.istalchumibakend.api.service.ListaReproduccionService;

@RestController
@RequestMapping("/api/lista")
public class ListaReproduccionController {

	@Autowired
	private ListaReproduccionService listaReproduccion;
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody ListaReproducion lista){
		return ResponseEntity.status(HttpStatus.CREATED).body(listaReproduccion.save(lista));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value="id")Long id_lista){
		Optional<ListaReproducion> oListaReproducion= listaReproduccion.findById(id_lista);
		if(!oListaReproducion.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oListaReproducion);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody ListaReproducion listadetails,@PathVariable(value="id")Long id_lista){
		Optional<ListaReproducion> listaNew=listaReproduccion.findById(id_lista);
		if(!listaNew.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		listaNew.get().setDescripcion(listadetails.getDescripcion());
		listaNew.get().setNombre(listadetails.getNombre());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(listaReproduccion.save(listaNew.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value="id")Long id_cancion){
		if(!listaReproduccion.findById(id_cancion).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		listaReproduccion.deleteById(id_cancion);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<ListaReproducion> readAll(){
		List<ListaReproducion> listasReproducciones=StreamSupport.stream(listaReproduccion.findAll().spliterator(), false).collect(Collectors.toList());
		return listasReproducciones;
	}
	
	
}
