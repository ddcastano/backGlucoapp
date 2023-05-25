package com.glucoapp.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import com.glucoapp.entidades.Registro24h;
import com.glucoapp.entidades.RegistroFecha;
import com.glucoapp.entidades.Registros;
import com.glucoapp.entidades.Usuario;
import com.glucoapp.utilidades.ConsultasSQL;

public class GlucoDaoJDBC {

	public int guardarUsuarioJDBC(DataSource datasource, Usuario us) {

		try {
			ConsultasSQL sqlDao = new ConsultasSQL();
			String sql = sqlDao.guardarUsuario(us);
			JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
			int insercion = 0;
			insercion = jdbcTemplate.update(sql);

			return insercion;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}

	}
	
	public int guardarRegistroJDBC(DataSource datasource, Registros rg) {

		try {
			ConsultasSQL sqlDao = new ConsultasSQL();
			String sql = sqlDao.guardarRegistro(rg);
			JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
			int insercion = 0;
			insercion = jdbcTemplate.update(sql);

			return insercion;

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return 0;
		}

	}
	
	public List<Registro24h> listaRegistro24h(DataSource datasource, String cedula) {
		ConsultasSQL sqlDao = new ConsultasSQL();

		List<Registro24h> lista24h = new ArrayList<>();

		String sql = sqlDao.listaUltimas24h(cedula);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);

		lista24h = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Registro24h.class));

		return lista24h;
	}
	
	
	public List<RegistroFecha> listaRegistroFecha(DataSource datasource,String fechaInicio,String fechaFin, String cedula) {
		ConsultasSQL sqlDao = new ConsultasSQL();

		List<RegistroFecha> lista24h = new ArrayList<>();

		String sql = sqlDao.listaFecha(fechaInicio, fechaFin, cedula);

		JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);

		lista24h = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(RegistroFecha.class));

		return lista24h;
	}
	
	public Usuario login(DataSource datasource, String cedula) {
	    ConsultasSQL sqlDao = new ConsultasSQL();
	    String sql = sqlDao.login(cedula);
	    JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
	    List<Usuario> usuarios = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Usuario.class));
	    if (!usuarios.isEmpty()) {
	        return usuarios.get(0);
	    } else {
	        return null;
	    }
	}
	
}
