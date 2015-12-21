package com.continent.web.dto;

import java.io.Serializable;
import java.util.Date;



public class SuscriptionDTO implements Serializable {
	private static final long serialVersionUID = 1L;


	private int id;


	private Date desTs;





	private Date fUltimoCobro;

	private EstadoDTO estado;


	private Date susTs;





	private ClienteDTO cliente;

//	des_user

	private CanalDTO canal1;
	
//	sus_user
	private CanalDTO canal2;
	
	private ServicioDTO servicio;

	public SuscriptionDTO() {
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDesTs() {
		return this.desTs;
	}

	public void setDesTs(Date desTs) {
		this.desTs = desTs;
	}



	public Date getFUltimoCobro() {
		return this.fUltimoCobro;
	}

	public void setFUltimoCobro(Date fUltimoCobro) {
		this.fUltimoCobro = fUltimoCobro;
	}



	public Date getfUltimoCobro() {
		return fUltimoCobro;
	}
	public void setfUltimoCobro(Date fUltimoCobro) {
		this.fUltimoCobro = fUltimoCobro;
	}
	public EstadoDTO getEstado() {
		return estado;
	}
	public void setEstado(EstadoDTO estado) {
		this.estado = estado;
	}
	public Date getSusTs() {
		return this.susTs;
	}

	public void setSusTs(Date susTs) {
		this.susTs = susTs;
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
	public CanalDTO getCanal1() {
		return canal1;
	}
	public void setCanal1(CanalDTO canal1) {
		this.canal1 = canal1;
	}
	public CanalDTO getCanal2() {
		return canal2;
	}
	public void setCanal2(CanalDTO canal2) {
		this.canal2 = canal2;
	}

	
	
}