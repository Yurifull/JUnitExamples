package com.samp.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="person")
public class PersonController{

	@Autowired
	private SrvBanco srvBanco;
	
	@GetMapping(value="/find-all", produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<BancoTO>> findAll() {
		info("Inicio listarBancosPagoInternet");
		ResponseEntity<List<BancoTO>> salida = null;
		try{
			iniciarMedicionTiempo();
			salida = new ResponseEntity<>(srvBanco.listarBancosPagoInternet(), null, HttpStatus.OK);
		}catch (UncategorizedSQLException |CannotGetJdbcConnectionException e) {
			throw new RecaudacionExternaException(CodErroresIntegracion.PVR_985, e);
		}finally {
			registraMedicionTiempo();			
		}
		return salida;
	}
}
