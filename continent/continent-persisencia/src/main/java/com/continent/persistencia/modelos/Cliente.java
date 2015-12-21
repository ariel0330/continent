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
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
//	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ms_isdn")
	private String msIsdn;

	//bi-directional many-to-one association to Operadore
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="smsc_id")
	private Operadore operadore;

	//bi-directional many-to-one association to Cobro
	@OneToMany(mappedBy="cliente")
	private List<Cobro> cobros;

	//bi-directional many-to-one association to Diyoupa
	@OneToMany(mappedBy="cliente")
	private List<Diyoupa> diyoupas;

	//bi-directional many-to-one association to HHomoDlr
	@OneToMany(mappedBy="cliente")
	private List<HHomoDlr> HHomoDlrs;

	//bi-directional many-to-one association to HomoDlr
	@OneToMany(mappedBy="cliente")
	private List<HomoDlr> homoDlrs;

	//bi-directional many-to-one association to Smschatrecv
	@OneToMany(mappedBy="cliente")
	private List<Smschatrecv> smschatrecvs;

	//bi-directional many-to-one association to Smschatsend
	@OneToMany(mappedBy="cliente")
	private List<Smschatsend> smschatsends;

	//bi-directional many-to-one association to Suscription
	@OneToMany(mappedBy="cliente")
	private List<Suscription> suscriptions;

	public Cliente() {
	}

	public String getMsIsdn() {
		return this.msIsdn;
	}

	public void setMsIsdn(String msIsdn) {
		this.msIsdn = msIsdn;
	}

	public Operadore getOperadore() {
		return this.operadore;
	}

	public void setOperadore(Operadore operadore) {
		this.operadore = operadore;
	}

	public List<Cobro> getCobros() {
		return this.cobros;
	}

	public void setCobros(List<Cobro> cobros) {
		this.cobros = cobros;
	}

	public Cobro addCobro(Cobro cobro) {
		getCobros().add(cobro);
		cobro.setCliente(this);

		return cobro;
	}

	public Cobro removeCobro(Cobro cobro) {
		getCobros().remove(cobro);
		cobro.setCliente(null);

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
		diyoupa.setCliente(this);

		return diyoupa;
	}

	public Diyoupa removeDiyoupa(Diyoupa diyoupa) {
		getDiyoupas().remove(diyoupa);
		diyoupa.setCliente(null);

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
		HHomoDlr.setCliente(this);

		return HHomoDlr;
	}

	public HHomoDlr removeHHomoDlr(HHomoDlr HHomoDlr) {
		getHHomoDlrs().remove(HHomoDlr);
		HHomoDlr.setCliente(null);

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
		homoDlr.setCliente(this);

		return homoDlr;
	}

	public HomoDlr removeHomoDlr(HomoDlr homoDlr) {
		getHomoDlrs().remove(homoDlr);
		homoDlr.setCliente(null);

		return homoDlr;
	}

	public List<Smschatrecv> getSmschatrecvs() {
		return this.smschatrecvs;
	}

	public void setSmschatrecvs(List<Smschatrecv> smschatrecvs) {
		this.smschatrecvs = smschatrecvs;
	}

	public Smschatrecv addSmschatrecv(Smschatrecv smschatrecv) {
		getSmschatrecvs().add(smschatrecv);
		smschatrecv.setCliente(this);

		return smschatrecv;
	}

	public Smschatrecv removeSmschatrecv(Smschatrecv smschatrecv) {
		getSmschatrecvs().remove(smschatrecv);
		smschatrecv.setCliente(null);

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
		smschatsend.setCliente(this);

		return smschatsend;
	}

	public Smschatsend removeSmschatsend(Smschatsend smschatsend) {
		getSmschatsends().remove(smschatsend);
		smschatsend.setCliente(null);

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
		suscription.setCliente(this);

		return suscription;
	}

	public Suscription removeSuscription(Suscription suscription) {
		getSuscriptions().remove(suscription);
		suscription.setCliente(null);

		return suscription;
	}

}