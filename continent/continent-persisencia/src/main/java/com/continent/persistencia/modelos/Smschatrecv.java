package com.continent.persistencia.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the smschatrecv database table.
 * 
 */
@Entity
@NamedQuery(name="Smschatrecv.findAll", query="SELECT s FROM Smschatrecv s")
public class Smschatrecv implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_smschatrecv")
	private int idSmschatrecv;

	private String msg;

	@Column(name="request_id")
	private BigDecimal requestId;

	@Column(name="smsc_id")
	private int smscId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ts_recv")
	private Date tsRecv;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ms_isdn")
	private Cliente cliente;

	//bi-directional many-to-one association to Servicio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="short_code")
	private Servicio servicio;

	public Smschatrecv() {
	}

	public int getIdSmschatrecv() {
		return this.idSmschatrecv;
	}

	public void setIdSmschatrecv(int idSmschatrecv) {
		this.idSmschatrecv = idSmschatrecv;
	}

	public String getMsg() {
		return this.msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public BigDecimal getRequestId() {
		return this.requestId;
	}

	public void setRequestId(BigDecimal requestId) {
		this.requestId = requestId;
	}

	public int getSmscId() {
		return this.smscId;
	}

	public void setSmscId(int smscId) {
		this.smscId = smscId;
	}

	public Date getTsRecv() {
		return this.tsRecv;
	}

	public void setTsRecv(Date tsRecv) {
		this.tsRecv = tsRecv;
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