package com.continent.persistencia.modelos;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the canal database table.
 * 
 */

@Entity
@NamedQuery(name="Canal.findAll", query="SELECT c FROM Canal c")
public class Canal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id_canal")
	private int idCanal;

	private String nombre;

	//bi-directional many-to-one association to Suscription
	@OneToMany(mappedBy="canal1")
	private List<Suscription> suscriptions1;

	//bi-directional many-to-one association to Suscription
	@OneToMany(mappedBy="canal2")
	private List<Suscription> suscriptions2;

	public Canal() {
	}

	public int getIdCanal() {
		return this.idCanal;
	}

	public void setIdCanal(int idCanal) {
		this.idCanal = idCanal;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Suscription> getSuscriptions1() {
		return this.suscriptions1;
	}

	public void setSuscriptions1(List<Suscription> suscriptions1) {
		this.suscriptions1 = suscriptions1;
	}

	public Suscription addSuscriptions1(Suscription suscriptions1) {
		getSuscriptions1().add(suscriptions1);
		suscriptions1.setCanal1(this);

		return suscriptions1;
	}

	public Suscription removeSuscriptions1(Suscription suscriptions1) {
		getSuscriptions1().remove(suscriptions1);
		suscriptions1.setCanal1(null);

		return suscriptions1;
	}

	public List<Suscription> getSuscriptions2() {
		return this.suscriptions2;
	}

	public void setSuscriptions2(List<Suscription> suscriptions2) {
		this.suscriptions2 = suscriptions2;
	}

	public Suscription addSuscriptions2(Suscription suscriptions2) {
		getSuscriptions2().add(suscriptions2);
		suscriptions2.setCanal2(this);

		return suscriptions2;
	}

	public Suscription removeSuscriptions2(Suscription suscriptions2) {
		getSuscriptions2().remove(suscriptions2);
		suscriptions2.setCanal2(null);

		return suscriptions2;
	}

}