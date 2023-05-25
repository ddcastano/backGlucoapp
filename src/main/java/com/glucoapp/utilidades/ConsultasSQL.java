package com.glucoapp.utilidades;

import com.glucoapp.entidades.Registros;
import com.glucoapp.entidades.Usuario;

public class ConsultasSQL {

	public String guardarUsuario(Usuario usuario) {

		String sql = "INSERT INTO gl_usuarios (cedula, nombre, contrasena, celular) " + "VALUES ('"
				+ usuario.getCedula() + "', '" + usuario.getNombre() + "', '" + usuario.getContrasena() + "', '"
				+ usuario.getCelular() + "')";

		return sql;
	}

	public String guardarRegistro(Registros registro) {

		String sql = "INSERT INTO gl_registros (glucometria, cedula, fechasys) VALUES (" + registro.getGlucometria()
				+ ", '" + registro.getCedula() + "', SYSDATE());";

		return sql;
	}

	public String listaUltimas24h(String cedula) {

		String sql = "SELECT glucometria, TIME(fechasys) hora FROM gl_registros WHERE fechasys BETWEEN DATE_SUB(NOW(), INTERVAL 24 HOUR) AND NOW() AND cedula = '"
				+ cedula + "' ";

		return sql;
	}

	public String listaFecha(String fechaInicio, String fechaFin, String cedula) {

		String sql = "	SELECT DATE(fechasys) DIA, ROUND(AVG(glucometria), 0) GLUCOMETRIA FROM gl_registros WHERE DATE(fechasys) BETWEEN '"
				+ fechaInicio + "' AND '" + fechaFin+ "' AND cedula = '"+cedula+"' GROUP BY DATE(fechasys) ";

		return sql;
	}
	
	public String login(String cedula) {
	    String sql = "SELECT * FROM gl_usuarios WHERE cedula = '" + cedula + "'";
	    return sql;
	}
	

}
