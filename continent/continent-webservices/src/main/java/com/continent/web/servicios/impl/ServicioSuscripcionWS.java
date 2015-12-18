package com.continent.web.servicios.impl;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.continent.persistencia.dao.interfaces.SuscriptionWSDaoI;
import com.continent.persistencia.modelos.SuscriptionWS;
import com.continent.web.dto.CanalDTO;
import com.continent.web.dto.OperadorDTO;
import com.continent.web.dto.ServicioDTO;
import com.continent.web.dto.SuscriptionWSDTO;
import com.continent.web.servicios.interfaces.IServicioSuscripcion;

@Service
public class ServicioSuscripcionWS extends ServicioGenerico<SuscriptionWSDTO,SuscriptionWS> implements IServicioSuscripcion{

	@Autowired
	ServicioCanal sc;
	
	@Autowired
	ServicioOperador so;
	
	@Autowired
	ServicioServicios ss;
	
	public ServicioSuscripcionWS() {
		super(SuscriptionWSDTO.class,SuscriptionWS.class);
	}

	@Autowired
		public void setDaoObject(SuscriptionWSDaoI daoObject) {
			super.setDaoObject(daoObject);
		}
	@Autowired
		public void setDozerMapper(DozerBeanMapper dozerMapper) {
			super.setDozerMapper(dozerMapper);
		}

	@Override
	public String validaSuscripcion(SuscriptionWSDTO entity) {
		
		CanalDTO canal= sc.obtenerPorPK(entity.getSusUser());
		if(canal == null)
		{
			return "El Canal de suscrripcion no es valido";
		}
		OperadorDTO operador = so.obtenerPorPK(entity.getCliente().getSmscId());
		if(operador == null)
		{
			return "El Operador de suscrripcion no es valido";
		}
		ServicioDTO servicio = ss.obtenerPorPK(entity.getShortcode());
		if(servicio == null)
		{
			return "El Servicio de suscrripcion no es valido";
		}
		return "Datos Correctos";
	}
}
