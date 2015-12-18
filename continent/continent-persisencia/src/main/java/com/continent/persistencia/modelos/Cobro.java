package com.continent.persistencia.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the cobros database table.
 * 
 */
@Entity
@Table(name="cobros")
@NamedQuery(name="Cobro.findAll", query="SELECT c FROM Cobro c")
public class Cobro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_cobro")
	private int idCobro;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="audit_fecha")
	private Date auditFecha;

	@Column(name="audit_prgm")
	private String auditPrgm;

	@Column(name="audit_user")
	private String auditUser;

	@Column(name="club_id")
	private int clubId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="fecha_cobro")
	private Date fechaCobro;

	private int importe;

	@Column(name="nombre_smsc")
	private String nombreSmsc;

	@Column(name="smsc_id")
	private int smscId;

	@Column(name="smsc_status_code")
	private int smscStatusCode;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ms_isdn")
	private Cliente cliente;

	//bi-directional many-to-one association to Servicio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="shortcode")
	private Servicio servicio;

	public Cobro() {
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