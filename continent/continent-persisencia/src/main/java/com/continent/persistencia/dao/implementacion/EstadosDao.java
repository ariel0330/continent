package com.continent.persistencia.dao.implementacion;

import org.springframework.stereotype.Repository;

import com.continent.persistencia.dao.interfaces.EstadosDaoI;
import com.continent.persistencia.modelos.Estado;

@Repository
public class EstadosDao extends GenericDao<Estado> implements EstadosDaoI {
	
	public EstadosDao(){
		super(Estado.class);
	}
	

}

