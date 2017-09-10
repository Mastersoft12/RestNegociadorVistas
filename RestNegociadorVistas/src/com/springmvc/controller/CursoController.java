package com.springmvc.controller;

import java.net.URI;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.model.Persona;

@RestController
@RequestMapping( value = "/curso")
public class CursoController {
	
	@RequestMapping( method = RequestMethod.POST, consumes="application/json")
    public ResponseEntity<Persona> insertUser(@RequestBody Persona user) {		
		Persona persona = setPersonasDao();
		HttpHeaders hearders = new HttpHeaders();
		URI locationUri = URI.create("http://localhost:8080/RestNegociadorVistas/persona/1");
		hearders.setLocation(locationUri);
		ResponseEntity<Persona> responseEntity = new ResponseEntity<>(user,hearders,HttpStatus.CREATED);
		return responseEntity;
    }
	
	private Persona setPersonasDao() {
		Persona persona = new Persona();
		persona.setApellido("Martinez");
		persona.setNombre("Fabio");
		return persona;
	}

}
