package com.continent.web.dto;

import java.io.Serializable;


public class ClubesServicioDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private int id;


	private ClubDTO clube;


	public ClubesServicioDTO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ClubDTO getClube() {
		return this.clube;
	}

	public void setClube(ClubDTO clube) {
		this.clube = clube;
	}

	

}