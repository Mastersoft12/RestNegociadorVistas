package com.springmvc.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.model.Error;
import com.springmvc.model.Persona;

@RestController
@RequestMapping( value = "/persona")
public class PersonaController {
	
	@RequestMapping( method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public Persona obtenerPersona(){
		Persona persona = setPersonasDao();
		return persona;
	}
	
	@RequestMapping( value = "/{id}", method=RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> obtenerPersonaById(@PathVariable int id){
		HttpStatus status;
		Persona persona = setPersonasDao();
		if(null != persona){
			 status = HttpStatus.OK;
			return new ResponseEntity<>(persona,status);
		}else{
			status = HttpStatus.NOT_FOUND;
			Error error = new Error(4, "Codigo: "+id+" no encontrado...");
			return new ResponseEntity<>(error,status);
		}
	}

	private Persona setPersonasDao() {
		Persona persona = new Persona();
		persona.setApellido("Martinez");
		persona.setNombre("Fabio");
		return persona;
	}
	
	

}
