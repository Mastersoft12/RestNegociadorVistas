package com.springmvc.model;

import java.io.Serializable;

public class Error implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int code;
	
	private String mensaje;
	
	public Error(int code, String mensaje) {
		this.code = code;
		this.mensaje = mensaje;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	
	

}
