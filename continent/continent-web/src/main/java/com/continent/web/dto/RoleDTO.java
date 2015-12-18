package com.continent.web.dto;

import java.io.Serializable;



public class RoleDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private int id;

	private String role;


	public RoleDTO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}