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

import com.istalchumibakend.api.entity.Cancion;
import com.istalchumibakend.api.entity.ListaReproducion;
import com.istalchumibakend.api.service.CancionService;

@RestController
@RequestMapping("/api/cancion")
public class CancionController {

	@Autowired
	private CancionService cancionService;
	
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Cancion cancion){
		return ResponseEntity.status(HttpStatus.CREATED).body(cancionService.save(cancion));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> read (@PathVariable(value="id")Long id_cancion){
		Optional<Cancion> oCancion= cancionService.findById(id_cancion);
		if(!oCancion.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oCancion);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody Cancion canciondetails,@PathVariable(value="id")Long id_cancion){
		Optional<Cancion> cancionNew=cancionService.findById(id_cancion);
		if(!cancionNew.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		cancionNew.get().setAlbum(canciondetails.getAlbum());
		cancionNew.get().setArtista(canciondetails.getArtista());
		cancionNew.get().setTitulo(canciondetails.getTitulo());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(cancionService.save(cancionNew.get()));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete (@PathVariable(value="id")Long id_cancion){
		if(!cancionService.findById(id_cancion).isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		cancionService.deleteById(id_cancion);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<Cancion> readAll(){
		List<Cancion> canciones=StreamSupport.stream(cancionService.findAll().spliterator(), false).collect(Collectors.toList());
		return canciones;
	}
	
}
