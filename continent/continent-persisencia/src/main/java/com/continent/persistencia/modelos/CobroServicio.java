package com.continent.persistencia.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cobro_servicio database table.
 * 
 */
@Entity
@Table(name="cobro_servicio")
@NamedQuery(name="CobroServicio.findAll", query="SELECT c FROM CobroServicio c")
public class CobroServicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_cobro_servicio")
	private int idCobroServicio;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_baja")
	private Date fechaBaja;

	private int periodicidad;

	//bi-directional many-to-one association to Servicio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="servicio")
	private Servicio servicioBean;

	public CobroServicio() {
	}

	public int getIdCobroServicio() {
		return this.idCobroServicio;
	}

	public void setIdCobroServicio(int idCobroServicio) {
		this.idCobroServicio = idCobroServicio;
	}

	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public int getPeriodicidad() {
		return this.periodicidad;
	}

	public void setPeriodicidad(int periodicidad) {
		this.periodicidad = periodicidad;
	}

	public Servicio getServicioBean() {
		return this.servicioBean;
	}

	public void setServicioBean(Servicio servicioBean) {
		this.servicioBean = servicioBean;
	}

}