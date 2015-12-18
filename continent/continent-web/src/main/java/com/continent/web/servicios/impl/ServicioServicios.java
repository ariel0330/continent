package com.continent.web.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.continent.persistencia.dao.interfaces.ServiciosDaoI;
import com.continent.persistencia.modelos.Servicio;
import com.continent.web.dto.ServicioDTO;
import com.continent.web.servicios.interfaces.IServicioServicios;
import com.continent.web.utils.MapperUtils;

@Service
public class ServicioServicios extends ServicioGenerico<ServicioDTO,Servicio> implements IServicioServicios{

	public ServicioServicios() {
		super(ServicioDTO.class,Servicio.class);
	}

	@Autowired
		public void setDaoObject(ServiciosDaoI daoObject) {
			super.setDaoObject(daoObject);
		}
	
	@Autowired
		public void setDozerMapper(DozerBeanMapper dozerMapper) {
			super.setDozerMapper(dozerMapper);
		}
	
	@Override
	public List<ServicioDTO> listar(int idServicio,int idEstado) {
		List<Servicio> listaEntity= ((ServiciosDaoI) this.getDaoObject()).BuscarServicio(idServicio, idEstado);
		List<ServicioDTO> listaEntityDTO = new ArrayList<ServicioDTO>();
		MapperUtils.map(dozerMapper, listaEntity, listaEntityDTO, ServicioDTO.class);
		return listaEntityDTO;
	}
	
}
