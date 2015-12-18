package com.continent.web.servicios.impl;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.continent.persistencia.dao.interfaces.RoleDaoI;
import com.continent.persistencia.modelos.Role;
import com.continent.web.dto.RoleDTO;
import com.continent.web.servicios.interfaces.IServicioRol;

@Service
public class ServicioRol extends ServicioGenerico<RoleDTO,Role> implements IServicioRol{

	
	public ServicioRol() {
		super(RoleDTO.class,Role.class);
	}

	@Autowired
		public void setDaoObject(RoleDaoI daoObject) {
			super.setDaoObject(daoObject);
		}
	@Autowired
		public void setDozerMapper(DozerBeanMapper dozerMapper) {
			super.setDozerMapper(dozerMapper);
		}
	
}
