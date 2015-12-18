package com.continent.persistencia.dao.interfaces;

import java.util.List;

import com.continent.persistencia.modelos.Cobro;

public interface CobroDaoI extends GenericDaoI<Cobro> {

	public List<Cobro> buscarCobro(int operadorID,int clubID);
}
