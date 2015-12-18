package com.continent.persistencia.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the suscriptions database table.
 * 
 */
@Entity
@Table(name="suscriptions")
@NamedQuery(name="Suscription.findAll", query="SELECT s FROM Suscription s")
public class Suscription implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="des_ts")
	private Date desTs;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="f_ultimo_cobro")
	private Date fUltimoCobro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sus_ts")
	private Date susTs;

	//bi-directional many-to-one association to Canal
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="des_user")
	private Canal canal1;

	//bi-directional many-to-one association to Canal
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="sus_user")
	private Canal canal2;

	//bi-directional many-to-one association to Estado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="status")
	private Estado estado;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ms_isdn")
	private Cliente cliente;

	//bi-directional many-to-one association to Servicio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="shortcode")
	private Servicio servicio;

	public Suscription() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDesTs() {
		return this.desTs;
	}

	public void setDesTs(Date desTs) {
		this.desTs = desTs;
	}

	public Date getFUltimoCobro() {
		return this.fUltimoCobro;
	}

	public void setFUltimoCobro(Date fUltimoCobro) {
		this.fUltimoCobro = fUltimoCobro;
	}

	public Date getSusTs() {
		return this.susTs;
	}

	public void setSusTs(Date susTs) {
		this.susTs = susTs;
	}

	public Canal getCanal1() {
		return this.canal1;
	}

	public void setCanal1(Canal canal1) {
		this.canal1 = canal1;
	}

	public Canal getCanal2() {
		return this.canal2;
	}

	public void setCanal2(Canal canal2) {
		this.canal2 = canal2;
	}

	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}