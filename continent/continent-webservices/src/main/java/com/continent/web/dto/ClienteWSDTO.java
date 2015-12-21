package com.continent.web.dto;

import java.io.Serializable;


/**
 * The persistent class for the clientes database table.
 * 
 */


public class ClienteWSDTO implements Serializable {
	private static final long serialVersionUID = 1L;



	private String msIsdn;


	private int smscId;

	

	public ClienteWSDTO() {
	}

	public String getMsIsdn() {
		return this.msIsdn;
	}

	public void setMsIsdn(String msIsdn) {
		this.msIsdn = msIsdn;
	}

	public int getSmscId() {
		return smscId;
	}

	public void setSmscId(int smscId) {
		this.smscId = smscId;
	}

	

}