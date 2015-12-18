package com.continent.persistencia.modelos;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the dlr database table.
 * 
 */
@Entity
@NamedQuery(name="Dlr.findAll", query="SELECT d FROM Dlr d")
public class Dlr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_dlr")
	private int idDlr;

	private String boxc;

	private String destination;

	private int mask;

	private String service;

	private String smsc;

	private String source;

	private int status;

	private String ts;

	private String url;

	public Dlr() {
	}

	public int getIdDlr() {
		return this.idDlr;
	}

	public void setIdDlr(int idDlr) {
		this.idDlr = idDlr;
	}

	public String getBoxc() {
		return this.boxc;
	}

	public void setBoxc(String boxc) {
		this.boxc = boxc;
	}

	public String getDestination() {
		return this.destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getMask() {
		return this.mask;
	}

	public void setMask(int mask) {
		this.mask = mask;
	}

	public String getService() {
		return this.service;
	}

	public void setService(String service) {
		this.service = service;
	}

	public String getSmsc() {
		return this.smsc;
	}

	public void setSmsc(String smsc) {
		this.smsc = smsc;
	}

	public String getSource() {
		return this.source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getTs() {
		return this.ts;
	}

	public void setTs(String ts) {
		this.ts = ts;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}