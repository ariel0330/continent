package com.continent.persistencia.modelos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the suscriptions database table.
 * 
 */
@Entity
@Table(name="suscriptions")
@NamedQuery(name="SuscriptionWS.findAll", query="SELECT s FROM SuscriptionWS s")
public class SuscriptionWS implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="des_ts")
	private Date desTs;

	@Column(name="des_user")
	private int desUser;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="f_ultimo_cobro")
	private Date fUltimoCobro;

//	@Column(name="ms_isdn")
//	private java.math.BigInteger msIsdn;

	private int shortcode;

	private int status;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="sus_ts")
	private Date susTs;

	@Column(name="sus_user")
	private int susUser;

	
	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ms_isdn")
	private ClienteWS cliente;
	
		
	public SuscriptionWS() {
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

	public int getDesUser() {
		return this.desUser;
	}

	public void setDesUser(int desUser) {
		this.desUser = desUser;
	}

	public Date getFUltimoCobro() {
		return this.fUltimoCobro;
	}

	public void setFUltimoCobro(Date fUltimoCobro) {
		this.fUltimoCobro = fUltimoCobro;
	}

//	public java.math.BigInteger getMsIsdn() {
//		return this.msIsdn;
//	}

//	public void setMsIsdn(java.math.BigInteger msIsdn) {
//		this.msIsdn = msIsdn;
//	}

	public int getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(int shortcode) {
		this.shortcode = shortcode;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Date getSusTs() {
		return this.susTs;
	}

	public void setSusTs(Date susTs) {
		this.susTs = susTs;
	}

	public int getSusUser() {
		return this.susUser;
	}

	public void setSusUser(int susUser) {
		this.susUser = susUser;
	}

	
	public ClienteWS getCliente() {
		return this.cliente;
	}

	public void setCliente(ClienteWS cliente) {
		this.cliente = cliente;
	}
	
}