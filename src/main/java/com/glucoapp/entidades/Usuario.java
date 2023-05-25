package com.glucoapp.entidades;

public class Usuario {

    private String cedula;
    private String nombre;
    private String contrasena;
    private String celular;

    
    public Usuario() {
		super();
	}

	// Constructor con todos los campos
    public Usuario(String cedula, String nombre, String contrasena, String celular) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.celular = celular;
    }

    // Getters y Setters

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

	@Override
	public String toString() {
		return "Usuario [cedula=" + cedula + ", nombre=" + nombre + ", contrasena=" + contrasena + ", celular="
				+ celular + "]";
	}
    
    
	
}
