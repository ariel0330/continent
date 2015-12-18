package com.continent.persistencia.dao.implementacion;

import org.springframework.stereotype.Repository;

import com.continent.persistencia.dao.interfaces.SuscriptionWSDaoI;
import com.continent.persistencia.modelos.SuscriptionWS;

@Repository
public class SuscriptionWSDao extends GenericDao<SuscriptionWS> implements SuscriptionWSDaoI {
	
	public SuscriptionWSDao(){
		super(SuscriptionWS.class);
	}
	
}

