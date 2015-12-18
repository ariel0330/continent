package com.continent.persistencia.modelos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the clubes_servicios database table.
 * 
 */
@Entity
@Table(name="clubes_servicios")
@NamedQuery(name="ClubesServicio.findAll", query="SELECT c FROM ClubesServicio c")
public class ClubesServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	//bi-directional many-to-one association to Clube
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="club_id")
	private Clube clube;

	//bi-directional many-to-one association to Servicio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="servicio_id")
	private Servicio servicio;

	public ClubesServicio() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Clube getClube() {
		return this.clube;
	}

	public void setClube(Clube clube) {
		this.clube = clube;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}