package com.continent.persistencia.dao.interfaces;

import java.util.List;

import com.continent.persistencia.modelos.Servicio;

public interface ServiciosDaoI extends GenericDaoI<Servicio> {

	public List<Servicio> BuscarServicio(int idServicio,int idEstado);
	
	public List<Servicio> BuscarServicio() ;
}
