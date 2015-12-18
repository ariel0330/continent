package com.continent.persistencia.dao.interfaces;

import java.util.List;

import com.continent.persistencia.modelos.Operadore;

public interface OperadorDaoI extends GenericDaoI<Operadore> {

	public List<Operadore> BuscarOperadador(int idOperador,int idEstado);
}
