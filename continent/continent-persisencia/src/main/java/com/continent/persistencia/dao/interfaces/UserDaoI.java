package com.continent.persistencia.dao.interfaces;

import java.util.List;

import com.continent.persistencia.modelos.User;

public interface UserDaoI extends GenericDaoI<User> {
	

	public List<User> BuscarUsuarios(int idPerfil,int idEstado);
	
}
