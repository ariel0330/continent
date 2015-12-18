package com.continent.web.dto;

import java.io.Serializable;
import java.util.Date;



public class ClubDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private int clubId;


	private Date auditFecha;


	private String auditPrgm;


	private String auditUser;


	private String clubName;

	private EstadoDTO estadoBean;


	private Date fechaAlta;


	private Date fechaBaja;

	//bi-directional many-to-one association to ClubesServicio
//	@OneToMany(mappedBy="clube")
//	private List<ClubesServicio> clubesServicios;

	public ClubDTO() {
	}

	public int getClubId() {
		return this.clubId;
	}

	public void setClubId(int clubId) {
		this.clubId = clubId;
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

	public String getClubName() {
		return this.clubName;
	}

	public void setClubName(String clubName) {
		this.clubName = clubName;
	}



	public Date getFechaAlta() {
		return this.fechaAlta;
	}

	public void setFechaAlta(Date fechaAlta) {
		this.fechaAlta = fechaAlta;
	}

	public Date getFechaBaja() {
		return this.fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public EstadoDTO getEstadoBean() {
		return estadoBean;
	}

	public void setEstadoBean(EstadoDTO estadoBean) {
		this.estadoBean = estadoBean;
	}

//	public List<ClubesServicio> getClubesServicios() {
//		return this.clubesServicios;
//	}
//
//	public void setClubesServicios(List<ClubesServicio> clubesServicios) {
//		this.clubesServicios = clubesServicios;
//	}
//
//	public ClubesServicio addClubesServicio(ClubesServicio clubesServicio) {
//		getClubesServicios().add(clubesServicio);
//		clubesServicio.setClube(this);
//
//		return clubesServicio;
//	}
//
//	public ClubesServicio removeClubesServicio(ClubesServicio clubesServicio) {
//		getClubesServicios().remove(clubesServicio);
//		clubesServicio.setClube(null);
//
//		return clubesServicio;
//	}

}