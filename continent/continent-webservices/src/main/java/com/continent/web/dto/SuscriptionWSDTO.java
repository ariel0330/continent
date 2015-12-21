package com.continent.web.dto;

import java.io.Serializable;



public class SuscriptionWSDTO implements Serializable {
	private static final long serialVersionUID = 1L;


//	private int id;


//	private Date desTs;


	private int desUser;


//	private Date fUltimoCobro;


//	private java.math.BigInteger msIsdn;

	private int shortcode;

	private int status;


	private ClienteWSDTO cliente;
	
//	private Date susTs;


	private int susUser;

	public SuscriptionWSDTO() {
	}

//	public int getId() {
//		return this.id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public Date getDesTs() {
//		return this.desTs;
//	}
//
//	public void setDesTs(Date desTs) {
//		this.desTs = desTs;
//	}

	public int getDesUser() {
		return this.desUser;
	}

	public void setDesUser(int desUser) {
		this.desUser = desUser;
	}

//	public Date getFUltimoCobro() {
//		return this.fUltimoCobro;
//	}
//
//	public void setFUltimoCobro(Date fUltimoCobro) {
//		this.fUltimoCobro = fUltimoCobro;
//	}

//	public java.math.BigInteger getMsIsdn() {
//		return this.msIsdn;
//	}
//
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

//	public Date getSusTs() {
//		return this.susTs;
//	}
//
//	public void setSusTs(Date susTs) {
//		this.susTs = susTs;
//	}

	public int getSusUser() {
		return this.susUser;
	}

	public void setSusUser(int susUser) {
		this.susUser = susUser;
	}
	
	public ClienteWSDTO getCliente() {
		return this.cliente;
	}

	public void setCliente(ClienteWSDTO cliente) {
		this.cliente = cliente;
	}

}