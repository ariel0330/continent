package com.continent.web.servicios.impl;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.continent.persistencia.dao.interfaces.CanalDaoI;
import com.continent.persistencia.modelos.Canal;
import com.continent.web.dto.CanalDTO;
import com.continent.web.servicios.interfaces.IServicioCanal;

@Service
public class ServicioCanal extends ServicioGenerico<CanalDTO,Canal> implements IServicioCanal{

	
	public ServicioCanal() {
		super(CanalDTO.class,Canal.class);
	}

	@Autowired
		public void setDaoObject(CanalDaoI daoObject) {
			super.setDaoObject(daoObject);
		}
	@Autowired
		public void setDozerMapper(DozerBeanMapper dozerMapper) {
			super.setDozerMapper(dozerMapper);
		}
}
