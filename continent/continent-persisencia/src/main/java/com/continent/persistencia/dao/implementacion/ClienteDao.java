package com.continent.persistencia.dao.implementacion;

import org.springframework.stereotype.Repository;

import com.continent.persistencia.dao.interfaces.ClienteDaoI;
import com.continent.persistencia.modelos.Cliente;

@Repository
public class ClienteDao extends GenericDao<Cliente> implements ClienteDaoI {
	
	public ClienteDao(){
		super(Cliente.class);
	}
	

}

