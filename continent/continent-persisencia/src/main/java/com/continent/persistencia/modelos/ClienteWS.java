package com.continent.persistencia.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the clientes database table.
 * 
 */
@Entity
@Table(name="clientes")
@NamedQuery(name="ClienteWS.findAll", query="SELECT c FROM ClienteWS c")
public class ClienteWS implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ms_isdn")
	private String msIsdn;


	@Column(name="smsc_id")
	private int smscId;

	public ClienteWS() {
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