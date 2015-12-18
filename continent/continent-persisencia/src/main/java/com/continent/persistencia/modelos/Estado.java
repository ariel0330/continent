package com.continent.persistencia.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the estados database table.
 * 
 */
@Entity
@Table(name="estados")
@NamedQuery(name="Estado.findAll", query="SELECT e FROM Estado e")
public class Estado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_estado")
	private int idEstado;

	private String estado;

	//bi-directional many-to-one association to Clube
	@OneToMany(mappedBy="estadoBean")
	private List<Clube> clubes;

	//bi-directional many-to-one association to Operadore
	@OneToMany(mappedBy="estadoBean")
	private List<Operadore> operadores;

	//bi-directional many-to-one association to Servicio
	@OneToMany(mappedBy="estadoBean")
	private List<Servicio> servicios;

	//bi-directional many-to-one association to Suscription
	@OneToMany(mappedBy="estado")
	private List<Suscription> suscriptions;

	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="estadoBean")
	private List<User> users;

	public Estado() {
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

	public List<Clube> getClubes() {
		return this.clubes;
	}

	public void setClubes(List<Clube> clubes) {
		this.clubes = clubes;
	}

	public Clube addClube(Clube clube) {
		getClubes().add(clube);
		clube.setEstadoBean(this);

		return clube;
	}

	public Clube removeClube(Clube clube) {
		getClubes().remove(clube);
		clube.setEstadoBean(null);

		return clube;
	}

	public List<Operadore> getOperadores() {
		return this.operadores;
	}

	public void setOperadores(List<Operadore> operadores) {
		this.operadores = operadores;
	}

	public Operadore addOperadore(Operadore operadore) {
		getOperadores().add(operadore);
		operadore.setEstadoBean(this);

		return operadore;
	}

	public Operadore removeOperadore(Operadore operadore) {
		getOperadores().remove(operadore);
		operadore.setEstadoBean(null);

		return operadore;
	}

	public List<Servicio> getServicios() {
		return this.servicios;
	}

	public void setServicios(List<Servicio> servicios) {
		this.servicios = servicios;
	}

	public Servicio addServicio(Servicio servicio) {
		getServicios().add(servicio);
		servicio.setEstadoBean(this);

		return servicio;
	}

	public Servicio removeServicio(Servicio servicio) {
		getServicios().remove(servicio);
		servicio.setEstadoBean(null);

		return servicio;
	}

	public List<Suscription> getSuscriptions() {
		return this.suscriptions;
	}

	public void setSuscriptions(List<Suscription> suscriptions) {
		this.suscriptions = suscriptions;
	}

	public Suscription addSuscription(Suscription suscription) {
		getSuscriptions().add(suscription);
		suscription.setEstado(this);

		return suscription;
	}

	public Suscription removeSuscription(Suscription suscription) {
		getSuscriptions().remove(suscription);
		suscription.setEstado(null);

		return suscription;
	}

	public List<User> getUsers() {
		return this.users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setEstadoBean(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setEstadoBean(null);

		return user;
	}

}