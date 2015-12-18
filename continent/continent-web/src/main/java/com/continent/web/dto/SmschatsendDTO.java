package com.continent.web.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


public class SmschatsendDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private int idSmschatrecv;

	private String body;


	private BigDecimal requestId;


	private Date tsSend;


	private ClienteDTO cliente;


	private ServicioDTO servicio;

	public SmschatsendDTO() {
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

	public ClienteDTO getCliente() {
		return this.cliente;
	}

	public void setCliente(ClienteDTO cliente) {
		this.cliente = cliente;
	}

	public ServicioDTO getServicio() {
		return this.servicio;
	}

	public void setServicio(ServicioDTO servicio) {
		this.servicio = servicio;
	}

}