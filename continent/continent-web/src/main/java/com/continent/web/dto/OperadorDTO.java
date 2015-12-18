package com.continent.web.dto;

import java.io.Serializable;


/**
 * The persistent class for the operadores database table.
 * 
 */

public class OperadorDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private int smscId;

	private String comentario;

	private EstadoDTO estadoBean;

	private String nombre;


//	private List<Cliente> clientes;

	public OperadorDTO() {
	}

	public int getSmscId() {
		return this.smscId;
	}

	public void setSmscId(int smscId) {
		this.smscId = smscId;
	}

	public String getComentario() {
		return this.comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}



	public EstadoDTO getEstadoBean() {
		return estadoBean;
	}

	public void setEstadoBean(EstadoDTO estadoBean) {
		this.estadoBean = estadoBean;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

//	public List<Cliente> getClientes() {
//		return this.clientes;
//	}
//
//	public void setClientes(List<Cliente> clientes) {
//		this.clientes = clientes;
//	}
//
//	public Cliente addCliente(Cliente cliente) {
//		getClientes().add(cliente);
//		cliente.setOperadore(this);
//
//		return cliente;
//	}
//
//	public Cliente removeCliente(Cliente cliente) {
//		getClientes().remove(cliente);
//		cliente.setOperadore(null);
//
//		return cliente;
//	}

}