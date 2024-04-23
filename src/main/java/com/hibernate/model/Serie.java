package com.hibernate.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Serie")
public class Serie {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "idSerie")
	private int idSerie;
	
	@Column(name = "nombre")
	private String nomCiudad;
	
	@Column(name = "temporadas")
	private int temporadas;

	@Column(name = "capitulos")
	private int capitulos;
	public Serie() {
		super();
	}
	
	public Serie(String nomCiudad, int temporadas,int capitulos) {
		super();
		this.nomCiudad = nomCiudad;
		this.temporadas = temporadas;
		this.capitulos = capitulos;
	}

	public int getIdSerie() {
		return idSerie;
	}

	public void setIdSerie(int idSerie) {
		this.idSerie = idSerie;
	}

	public String getNomCiudad() {
		return nomCiudad;
	}

	public void setNomCiudad(String nomCiudad) {
		this.nomCiudad = nomCiudad;
	}

	public int getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(int temporadas) {
		this.temporadas = temporadas;
	}

	public int getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(int capitulos) {
		this.capitulos = capitulos;
	}
}
