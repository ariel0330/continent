package com.continent.persistencia.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the operadores database table.
 * 
 */
@Entity
@Table(name="operadores")
@NamedQuery(name="Operadore.findAll", query="SELECT o FROM Operadore o")
public class Operadore implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="smsc_id")
	private int smscId;

	private String comentario;

	private String nombre;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="operadore")
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Estado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="estado")
	private Estado estadoBean;

	public Operadore() {
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

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setOperadore(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setOperadore(null);

		return cliente;
	}

	public Estado getEstadoBean() {
		return this.estadoBean;
	}

	public void setEstadoBean(Estado estadoBean) {
		this.estadoBean = estadoBean;
	}

}