package com.glucoapp.entidades;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

public class Registros {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "glucometria")
	private int glucometria;

	@Column(name = "cedula")
	private String cedula;

	@Column(name = "fechasys")
	private LocalDateTime fechaSys;

	public Registros(Long id, int glucometria, String cedula, LocalDateTime fechaSys) {
		super();
		this.id = id;
		this.glucometria = glucometria;
		this.cedula = cedula;
		this.fechaSys = fechaSys;
	}

	public Registros() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getGlucometria() {
		return glucometria;
	}

	public void setGlucometria(int glucometria) {
		this.glucometria = glucometria;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public LocalDateTime getFechaSys() {
		return fechaSys;
	}

	public void setFechaSys(LocalDateTime fechaSys) {
		this.fechaSys = fechaSys;
	}

	@Override
	public String toString() {
		return "Registros [id=" + id + ", glucometria=" + glucometria + ", cedula=" + cedula + ", fechaSys=" + fechaSys
				+ "]";
	}

	
	
	
}
