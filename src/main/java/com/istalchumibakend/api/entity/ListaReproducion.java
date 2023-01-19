package com.istalchumibakend.api.entity;

import java.io.Serializable;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name= "listareproducion")
public class ListaReproducion implements Serializable{

	private static final long serialVersionUID = 6326046231964787194L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_lista;
	
	@Column(length = 50,nullable = false,unique = true)
	private String nombre;
	
	@Column(name = "descripcion")
	private String descripcion;
	
	@OneToMany(mappedBy = "lista")
	private List<Cancion> canciones;

	public Long getId_cancion() {
		return id_lista;
	}

	public void setId_cancion(Long id_lista) {
		this.id_lista = id_lista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<Cancion> getCanciones() {
		return canciones;
	}

	public void setCanciones(List<Cancion> canciones) {
		this.canciones = canciones;
	}
	
	

}
