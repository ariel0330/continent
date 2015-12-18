package com.continent.persistencia.dao.interfaces;

import java.util.List;

import com.continent.persistencia.modelos.Suscription;

public interface SuscriptionDaoI extends GenericDaoI<Suscription> {


	
	public List<Suscription> ReporteSuscriptiones(int operadorID,int clubID,int estadoSuscripcion,int idCanal,String fecha);
}
