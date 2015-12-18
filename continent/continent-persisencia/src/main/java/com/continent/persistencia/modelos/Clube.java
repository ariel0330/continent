package com.continent.persistencia.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the clubes database table.
 * 
 */
@Entity
@Table(name="clubes")
@NamedQuery(name="Clube.findAll", query="SELECT c FROM Clube c")
public class Clube implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="club_id")
	private int clubId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="audit_fecha")
	private Date auditFecha;

	@Column(name="audit_prgm")
	private String auditPrgm;

	@Column(name="audit_user")
	private String auditUser;

	@Column(name="club_name")
	private String clubName;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_alta")
	private Date fechaAlta;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_baja")
	private Date fechaBaja;

	//bi-directional many-to-one association to Estado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="estado")
	private Estado estadoBean;

	//bi-directional many-to-one association to ClubesServicio
	@OneToMany(mappedBy="clube")
	private List<ClubesServicio> clubesServicios;

	public Clube() {
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

	public Estado getEstadoBean() {
		return this.estadoBean;
	}

	public void setEstadoBean(Estado estadoBean) {
		this.estadoBean = estadoBean;
	}

	public List<ClubesServicio> getClubesServicios() {
		return this.clubesServicios;
	}

	public void setClubesServicios(List<ClubesServicio> clubesServicios) {
		this.clubesServicios = clubesServicios;
	}

	public ClubesServicio addClubesServicio(ClubesServicio clubesServicio) {
		getClubesServicios().add(clubesServicio);
		clubesServicio.setClube(this);

		return clubesServicio;
	}

	public ClubesServicio removeClubesServicio(ClubesServicio clubesServicio) {
		getClubesServicios().remove(clubesServicio);
		clubesServicio.setClube(null);

		return clubesServicio;
	}

}