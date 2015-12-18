package com.continent.persistencia.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the homo_dlr database table.
 * 
 */
@Entity
@Table(name="homo_dlr")
@NamedQuery(name="HomoDlr.findAll", query="SELECT h FROM HomoDlr h")
public class HomoDlr implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sms_id")
	private int smsId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="audit_fecha")
	private Date auditFecha;

	@Column(name="audit_prgm")
	private String auditPrgm;

	@Column(name="audit_user")
	private String auditUser;

	@Column(name="delivery_report")
	private String deliveryReport;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dlr_date")
	private Date dlrDate;

	private int requestid;

	@Column(name="status_code")
	private int statusCode;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ms_isdn")
	private Cliente cliente;

	//bi-directional many-to-one association to Servicio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="shortcode")
	private Servicio servicio;

	public HomoDlr() {
	}

	public int getSmsId() {
		return this.smsId;
	}

	public void setSmsId(int smsId) {
		this.smsId = smsId;
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

	public String getDeliveryReport() {
		return this.deliveryReport;
	}

	public void setDeliveryReport(String deliveryReport) {
		this.deliveryReport = deliveryReport;
	}

	public Date getDlrDate() {
		return this.dlrDate;
	}

	public void setDlrDate(Date dlrDate) {
		this.dlrDate = dlrDate;
	}

	public int getRequestid() {
		return this.requestid;
	}

	public void setRequestid(int requestid) {
		this.requestid = requestid;
	}

	public int getStatusCode() {
		return this.statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
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