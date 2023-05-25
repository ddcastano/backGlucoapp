package com.glucoapp.entidades;

public class RegistroFecha {

	private int glucometria;
	private String dia;

	public RegistroFecha(int glucometria, String dia) {
		super();
		this.glucometria = glucometria;
		this.dia = dia;
	}

	public RegistroFecha() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getGlucometria() {
		return glucometria;
	}

	public void setGlucometria(int glucometria) {
		this.glucometria = glucometria;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	@Override
	public String toString() {
		return "RegistroFecha [glucometria=" + glucometria + ", dia=" + dia + "]";
	}

}
