package com.continent.persistencia.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the servicios database table.
 * 
 */
@Entity
@Table(name="servicios")
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int shortcode;

	private double costo;

	@Column(name="palabra_corta")
	private String palabraCorta;

	//bi-directional many-to-one association to ClubesServicio
	@OneToMany(mappedBy="servicio")
	private List<ClubesServicio> clubesServicios;

	//bi-directional many-to-one association to CobroServicio
	@OneToMany(mappedBy="servicioBean")
	private List<CobroServicio> cobroServicios;

	//bi-directional many-to-one association to Cobro
	@OneToMany(mappedBy="servicio")
	private List<Cobro> cobros;

	//bi-directional many-to-one association to Diyoupa
	@OneToMany(mappedBy="servicio")
	private List<Diyoupa> diyoupas;

	//bi-directional many-to-one association to HHomoDlr
	@OneToMany(mappedBy="servicio")
	private List<HHomoDlr> HHomoDlrs;

	//bi-directional many-to-one association to HomoDlr
	@OneToMany(mappedBy="servicio")
	private List<HomoDlr> homoDlrs;

	//bi-directional many-to-one association to Estado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="estado")
	private Estado estadoBean;

	//bi-directional many-to-one association to Smschatrecv
	@OneToMany(mappedBy="servicio")
	private List<Smschatrecv> smschatrecvs;

	//bi-directional many-to-one association to Smschatsend
	@OneToMany(mappedBy="servicio")
	private List<Smschatsend> smschatsends;

	//bi-directional many-to-one association to Suscription
	@OneToMany(mappedBy="servicio")
	private List<Suscription> suscriptions;

	public Servicio() {
	}

	public int getShortcode() {
		return this.shortcode;
	}

	public void setShortcode(int shortcode) {
		this.shortcode = shortcode;
	}

	public double getCosto() {
		return this.costo;
	}

	public void setCosto(double costo) {
		this.costo = costo;
	}

	public String getPalabraCorta() {
		return this.palabraCorta;
	}

	public void setPalabraCorta(String palabraCorta) {
		this.palabraCorta = palabraCorta;
	}

	public List<ClubesServicio> getClubesServicios() {
		return this.clubesServicios;
	}

	public void setClubesServicios(List<ClubesServicio> clubesServicios) {
		this.clubesServicios = clubesServicios;
	}

	public ClubesServicio addClubesServicio(ClubesServicio clubesServicio) {
		getClubesServicios().add(clubesServicio);
		clubesServicio.setServicio(this);

		return clubesServicio;
	}

	public ClubesServicio removeClubesServicio(ClubesServicio clubesServicio) {
		getClubesServicios().remove(clubesServicio);
		clubesServicio.setServicio(null);

		return clubesServicio;
	}

	public List<CobroServicio> getCobroServicios() {
		return this.cobroServicios;
	}

	public void setCobroServicios(List<CobroServicio> cobroServicios) {
		this.cobroServicios = cobroServicios;
	}

	public CobroServicio addCobroServicio(CobroServicio cobroServicio) {
		getCobroServicios().add(cobroServicio);
		cobroServicio.setServicioBean(this);

		return cobroServicio;
	}

	public CobroServicio removeCobroServicio(CobroServicio cobroServicio) {
		getCobroServicios().remove(cobroServicio);
		cobroServicio.setServicioBean(null);

		return cobroServicio;
	}

	public List<Cobro> getCobros() {
		return this.cobros;
	}

	public void setCobros(List<Cobro> cobros) {
		this.cobros = cobros;
	}

	public Cobro addCobro(Cobro cobro) {
		getCobros().add(cobro);
		cobro.setServicio(this);

		return cobro;
	}

	public Cobro removeCobro(Cobro cobro) {
		getCobros().remove(cobro);
		cobro.setServicio(null);

		return cobro;
	}

	public List<Diyoupa> getDiyoupas() {
		return this.diyoupas;
	}

	public void setDiyoupas(List<Diyoupa> diyoupas) {
		this.diyoupas = diyoupas;
	}

	public Diyoupa addDiyoupa(Diyoupa diyoupa) {
		getDiyoupas().add(diyoupa);
		diyoupa.setServicio(this);

		return diyoupa;
	}

	public Diyoupa removeDiyoupa(Diyoupa diyoupa) {
		getDiyoupas().remove(diyoupa);
		diyoupa.setServicio(null);

		return diyoupa;
	}

	public List<HHomoDlr> getHHomoDlrs() {
		return this.HHomoDlrs;
	}

	public void setHHomoDlrs(List<HHomoDlr> HHomoDlrs) {
		this.HHomoDlrs = HHomoDlrs;
	}

	public HHomoDlr addHHomoDlr(HHomoDlr HHomoDlr) {
		getHHomoDlrs().add(HHomoDlr);
		HHomoDlr.setServicio(this);

		return HHomoDlr;
	}

	public HHomoDlr removeHHomoDlr(HHomoDlr HHomoDlr) {
		getHHomoDlrs().remove(HHomoDlr);
		HHomoDlr.setServicio(null);

		return HHomoDlr;
	}

	public List<HomoDlr> getHomoDlrs() {
		return this.homoDlrs;
	}

	public void setHomoDlrs(List<HomoDlr> homoDlrs) {
		this.homoDlrs = homoDlrs;
	}

	public HomoDlr addHomoDlr(HomoDlr homoDlr) {
		getHomoDlrs().add(homoDlr);
		homoDlr.setServicio(this);

		return homoDlr;
	}

	public HomoDlr removeHomoDlr(HomoDlr homoDlr) {
		getHomoDlrs().remove(homoDlr);
		homoDlr.setServicio(null);

		return homoDlr;
	}

	public Estado getEstadoBean() {
		return this.estadoBean;
	}

	public void setEstadoBean(Estado estadoBean) {
		this.estadoBean = estadoBean;
	}

	public List<Smschatrecv> getSmschatrecvs() {
		return this.smschatrecvs;
	}

	public void setSmschatrecvs(List<Smschatrecv> smschatrecvs) {
		this.smschatrecvs = smschatrecvs;
	}

	public Smschatrecv addSmschatrecv(Smschatrecv smschatrecv) {
		getSmschatrecvs().add(smschatrecv);
		smschatrecv.setServicio(this);

		return smschatrecv;
	}

	public Smschatrecv removeSmschatrecv(Smschatrecv smschatrecv) {
		getSmschatrecvs().remove(smschatrecv);
		smschatrecv.setServicio(null);

		return smschatrecv;
	}

	public List<Smschatsend> getSmschatsends() {
		return this.smschatsends;
	}

	public void setSmschatsends(List<Smschatsend> smschatsends) {
		this.smschatsends = smschatsends;
	}

	public Smschatsend addSmschatsend(Smschatsend smschatsend) {
		getSmschatsends().add(smschatsend);
		smschatsend.setServicio(this);

		return smschatsend;
	}

	public Smschatsend removeSmschatsend(Smschatsend smschatsend) {
		getSmschatsends().remove(smschatsend);
		smschatsend.setServicio(null);

		return smschatsend;
	}

	public List<Suscription> getSuscriptions() {
		return this.suscriptions;
	}

	public void setSuscriptions(List<Suscription> suscriptions) {
		this.suscriptions = suscriptions;
	}

	public Suscription addSuscription(Suscription suscription) {
		getSuscriptions().add(suscription);
		suscription.setServicio(this);

		return suscription;
	}

	public Suscription removeSuscription(Suscription suscription) {
		getSuscriptions().remove(suscription);
		suscription.setServicio(null);

		return suscription;
	}

}