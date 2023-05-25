package com.glucoapp.entidades;

public class Registro24h {

	private int glucometria;
	private String hora;

	public Registro24h(int glucometria, String hora) {
		super();
		this.glucometria = glucometria;
		this.hora = hora;
	}

	public Registro24h() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getGlucometria() {
		return glucometria;
	}

	public void setGlucometria(int glucometria) {
		this.glucometria = glucometria;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	@Override
	public String toString() {
		return "Registro24h [glucometria=" + glucometria + ", hora=" + hora + "]";
	}

}
