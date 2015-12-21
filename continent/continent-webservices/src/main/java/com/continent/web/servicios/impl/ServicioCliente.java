package com.continent.web.servicios.impl;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.continent.persistencia.dao.interfaces.ClienteDaoI;
import com.continent.persistencia.modelos.Cliente;
import com.continent.web.dto.ClienteDTO;
import com.continent.web.servicios.interfaces.IServicioCliente;

@Service
public class ServicioCliente extends ServicioGenerico<ClienteDTO,Cliente> implements IServicioCliente{

	
	public ServicioCliente() {
		super(ClienteDTO.class,Cliente.class);
	}

	@Autowired
		public void setDaoObject(ClienteDaoI daoObject) {
			super.setDaoObject(daoObject);
		}
	@Autowired
		public void setDozerMapper(DozerBeanMapper dozerMapper) {
			super.setDozerMapper(dozerMapper);
		}
}
