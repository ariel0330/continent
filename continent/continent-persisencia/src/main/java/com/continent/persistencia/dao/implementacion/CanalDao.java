package com.continent.persistencia.dao.implementacion;

import org.springframework.stereotype.Repository;

import com.continent.persistencia.dao.interfaces.CanalDaoI;
import com.continent.persistencia.modelos.Canal;

@Repository
public class CanalDao extends GenericDao<Canal> implements CanalDaoI {
	
	public CanalDao(){
		super(Canal.class);
	}
	

}

