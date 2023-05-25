package com.glucoapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.glucoapp.Config;
import com.glucoapp.dao.GlucoDaoJDBC;
import com.glucoapp.entidades.Registro24h;
import com.glucoapp.entidades.RegistroFecha;
import com.glucoapp.entidades.Registros;
import com.glucoapp.entidades.Usuario;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping("/api")
public class GlucoController {

	@PostMapping(path = "/guardarUsuario")
	public int guardarUsuarios(@RequestBody Usuario usuario) {
		
		Config configuration = new Config();

		GlucoDaoJDBC glucoJDBC = new GlucoDaoJDBC();
		
		DataSource datasource = configuration.conexion();

		return glucoJDBC.guardarUsuarioJDBC(datasource, usuario);
	}
	
	@PostMapping(path = "/guardarRegistro")
	public int guardarRegistro(@RequestBody Registros registro) {
		
		Config configuration = new Config();

		GlucoDaoJDBC glucoJDBC = new GlucoDaoJDBC();
		
		DataSource datasource = configuration.conexion();

		return glucoJDBC.guardarRegistroJDBC(datasource, registro);
	}
	
	@GetMapping(path = "/lista24h/{cedula}")
	public ResponseEntity<List<Registro24h>> listar24h(@PathVariable String cedula) {
		Config configuration = new Config();
		
		List<Registro24h> lista24h = new ArrayList<>();

		try {
	
			
			GlucoDaoJDBC glucoJDBC = new GlucoDaoJDBC();
			DataSource datasource = configuration.conexion();

			lista24h = glucoJDBC.listaRegistro24h(datasource, cedula);

			return ResponseEntity.ok(lista24h);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.ok(lista24h = new ArrayList<>());
		}

	}
	
	@GetMapping(path = "/listarFecha/{fechaInicio}/{fechaFin}/{cedula}")
	public ResponseEntity<List<RegistroFecha>> listarFecha(@PathVariable String fechaInicio, @PathVariable String fechaFin, @PathVariable String cedula) {
		Config configuration = new Config();
		
		List<RegistroFecha> listaFecha = new ArrayList<>();

		try {
	
			
			GlucoDaoJDBC glucoJDBC = new GlucoDaoJDBC();
			DataSource datasource = configuration.conexion();

			listaFecha = glucoJDBC.listaRegistroFecha(datasource, fechaInicio,fechaFin,cedula);

			return ResponseEntity.ok(listaFecha);

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return ResponseEntity.ok(listaFecha = new ArrayList<>());
		}

	}
	
	@PostMapping(path = "/login")
	public ResponseEntity<Usuario> login(@RequestBody Usuario usuario) {
	    Config configuration = new Config();
	    GlucoDaoJDBC glucoJDBC = new GlucoDaoJDBC();
	    DataSource datasource = configuration.conexion();
	    Usuario usuarioAutenticado = glucoJDBC.login(datasource, usuario.getCedula());
	    if (usuarioAutenticado != null && usuarioAutenticado.getContrasena().equals(usuario.getContrasena())) {
	        return ResponseEntity.ok(usuarioAutenticado);
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	@PostMapping(path = "/autenticar")
	public ResponseEntity<Boolean> autenticar(@RequestBody Usuario usuario) {
	    Config configuration = new Config();
	    GlucoDaoJDBC glucoJDBC = new GlucoDaoJDBC();
	    DataSource datasource = configuration.conexion();
	    Usuario usuarioAutenticado = glucoJDBC.login(datasource, usuario.getCedula());
	    if (usuarioAutenticado != null && usuarioAutenticado.getContrasena().equals(usuario.getContrasena())) {
	        return ResponseEntity.ok(true);
	    } else {
	        return ResponseEntity.ok(false);
	    }
	}
	
}
