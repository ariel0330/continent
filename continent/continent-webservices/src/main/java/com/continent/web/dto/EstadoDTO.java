package com.continent.web.dto;

import java.io.Serializable;


public class EstadoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int idEstado;

	private String estado;

	

	public EstadoDTO() {
	}

	public int getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(int idEstado) {
		this.idEstado = idEstado;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	}