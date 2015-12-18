package com.continent.persistencia.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the smschatsend database table.
 * 
 */
@Entity
@NamedQuery(name="Smschatsend.findAll", query="SELECT s FROM Smschatsend s")
public class Smschatsend implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_smschatrecv")
	private int idSmschatrecv;

	private String body;

	@Column(name="request_id")
	private BigDecimal requestId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ts_send")
	private Date tsSend;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ms_isdn")
	private Cliente cliente;

	//bi-directional many-to-one association to Servicio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="short_code")
	private Servicio servicio;

	public Smschatsend() {
	}

	public int getIdSmschatrecv() {
		return this.idSmschatrecv;
	}

	public void setIdSmschatrecv(int idSmschatrecv) {
		this.idSmschatrecv = idSmschatrecv;
	}

	public String getBody() {
		return this.body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public BigDecimal getRequestId() {
		return this.requestId;
	}

	public void setRequestId(BigDecimal requestId) {
		this.requestId = requestId;
	}

	public Date getTsSend() {
		return this.tsSend;
	}

	public void setTsSend(Date tsSend) {
		this.tsSend = tsSend;
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