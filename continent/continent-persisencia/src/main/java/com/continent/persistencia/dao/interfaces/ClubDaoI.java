package com.continent.persistencia.dao.interfaces;

import java.util.List;

import com.continent.persistencia.modelos.Clube;

public interface ClubDaoI extends GenericDaoI<Clube> {

	public List<Clube> BuscarClub(int idClube,int idEstado);
}
