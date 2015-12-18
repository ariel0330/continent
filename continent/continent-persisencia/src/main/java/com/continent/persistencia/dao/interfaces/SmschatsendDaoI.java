package com.continent.persistencia.dao.interfaces;

import java.util.List;

import com.continent.persistencia.modelos.Smschatsend;

public interface SmschatsendDaoI extends GenericDaoI<Smschatsend> {
	
	
	public List<Smschatsend> buscarSMS(int operadorID,int clubID,String fecha);

}
