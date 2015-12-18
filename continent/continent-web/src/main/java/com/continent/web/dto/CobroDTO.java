package com.continent.web.dto;

import java.io.Serializable;
import java.util.Date;


public class CobroDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private int idCobro;


	private Date auditFecha;


	private String auditPrgm;


	private String auditUser;


	private int clubId;


	private Date fechaCobro;

	private int importe;


	private String nombreSmsc;


	private int smscId;


	private int smscStatusCode;


	private ClienteDTO cliente;


	private ServicioDTO servicio;

	public CobroDTO() {
	}

	public int getIdCobro() {
		return this.idCobro;
	}

	public void setIdCobro(int idCobro) {
		this.idCobro = idCobro;
	}

	public Date getAuditFecha() {
		return this.auditFecha;
	}

	public void setAuditFecha(Date auditFecha) {
		this.auditFecha = auditFecha;
	}

	public String getAuditPrgm() {
		return this.auditPrgm;
	}

	public void setAuditPrgm(String auditPrgm) {
		this.auditPrgm = auditPrgm;
	}

	public String getAuditUser() {
		return this.auditUser;
	}

	public void setAuditUser(String auditUser) {
		this.auditUser = auditUser;
	}

	public int getClubId() {
		return this.clubId;
	}

	public void setClubId(int clubId) {
		this.clubId = clubId;
	}

	public Date getFechaCobro() {
		return this.fechaCobro;
	}

	public void setFechaCobro(Date fechaCobro) {
		this.fechaCobro = fechaCobro;
	}

	public int getImporte() {
		return this.importe;
	}

	public void setImporte(int importe) {
		this.importe = importe;
	}

	public String getNombreSmsc() {
		return this.nombreSmsc;
	}

	public void setNombreSmsc(String nombreSmsc) {
		this.nombreSmsc = nombreSmsc;
	}

	public int getSmscId() {
		return this.smscId;
	}

	public void setSmscId(int smscId) {
		this.smscId = smscId;
	}

	public int getSmscStatusCode() {
		return this.smscStatusCode;
	}

	public void setSmscStatusCode(int smscStatusCode) {
		this.smscStatusCode = smscStatusCode;
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