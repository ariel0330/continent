package com.continent.web.dto;

import java.io.Serializable;


public class CanalDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idCanal;

	private String nombre;


	public CanalDTO() {
	}

	public int getIdCanal() {
		return this.idCanal;
	}

	public void setIdCanal(int idCanal) {
		this.idCanal = idCanal;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	
}