package com.continent.web.servicios.impl;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.continent.persistencia.dao.interfaces.EstadosDaoI;
import com.continent.persistencia.modelos.Estado;
import com.continent.web.dto.EstadoDTO;
import com.continent.web.servicios.interfaces.IServicioEstados;

@Service
public class ServicioEstado extends ServicioGenerico<EstadoDTO,Estado> implements IServicioEstados{

	public ServicioEstado() {
		super(EstadoDTO.class,Estado.class);
	}

	@Autowired
		public void setDaoObject(EstadosDaoI daoObject) {
			super.setDaoObject(daoObject);
		}
	@Autowired
		public void setDozerMapper(DozerBeanMapper dozerMapper) {
			super.setDozerMapper(dozerMapper);
		}
	
	
}
