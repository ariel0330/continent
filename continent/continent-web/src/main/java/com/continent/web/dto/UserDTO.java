package com.continent.web.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private int id;

	private String login;

	private String password;

	private EstadoDTO estadoBean=new EstadoDTO();

	private int idRol;
	
	private List<RoleDTO> roles=new ArrayList<RoleDTO>();

	public UserDTO() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public EstadoDTO getEstadoBean() {
		return this.estadoBean;
	}

	public void setEstadoBean(EstadoDTO estadoBean) {
		this.estadoBean = estadoBean;
	}

	public List<RoleDTO> getRoles() {
		return this.roles;
	}

	public void setRoles(List<RoleDTO> roles) {
		this.roles = roles;
	}

	public int getIdRol() {
		return idRol;
	}

	public void setIdRol(int idRol) {
		this.idRol = idRol;
	}

}