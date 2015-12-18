package com.continent.web.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.continent.persistencia.dao.interfaces.SuscriptionDaoI;
import com.continent.persistencia.modelos.Suscription;
import com.continent.web.dto.SuscriptionDTO;
import com.continent.web.servicios.interfaces.IServicioInfromeSus;
import com.continent.web.utils.MapperUtils;

@Service
public class ServicioInformeSus extends ServicioGenerico<SuscriptionDTO,Suscription> implements IServicioInfromeSus{

	
	public ServicioInformeSus() {
		super(SuscriptionDTO.class,Suscription.class);
	}

	@Autowired
		public void setDaoObject(SuscriptionDaoI daoObject) {
			super.setDaoObject(daoObject);
		}
	@Autowired
		public void setDozerMapper(DozerBeanMapper dozerMapper) {
			super.setDozerMapper(dozerMapper);
		}

	@Override
	public List<SuscriptionDTO> listar(int operadorID,int clubID,int estadoSuscripcion,int idCanal,String fecha) {
		List<Suscription> listaEntity= ((SuscriptionDaoI) this.getDaoObject()).ReporteSuscriptiones(operadorID, clubID,estadoSuscripcion,idCanal,fecha);
		List<SuscriptionDTO> listaEntityDTO = new ArrayList<SuscriptionDTO>();
		MapperUtils.map(dozerMapper, listaEntity, listaEntityDTO, SuscriptionDTO.class);
		return listaEntityDTO;
	}

	
}
