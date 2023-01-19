package com.istalchumibakend.api.entity;

import java.io.Serializable;
import java.util.Date;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name= "cancion")
public class Cancion implements Serializable{

	
	private static final long serialVersionUID = -1471878335326506025L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(length = 100, nullable=false)
	private String titulo;
	
	@Column(name = "artista", nullable = false,unique = true)
	private String artista;
	
	@Column(name = "album")
	private String album;
	
	@Column(name="fecha")
	@Temporal(TemporalType.DATE)
	private Date createat;
	
	@ManyToOne
	@JoinColumn(name = "id_lista")
	private ListaReproducion lista;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Date getCreateat() {
		return createat;
	}

	public void setCreateat(Date createat) {
		this.createat = createat;
	}

	public ListaReproducion getLista() {
		return lista;
	}

	public void setLista(ListaReproducion lista) {
		this.lista = lista;
	}

	
	
	
}
