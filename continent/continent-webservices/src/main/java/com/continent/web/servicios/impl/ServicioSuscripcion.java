package com.continent.web.servicios.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.continent.persistencia.dao.interfaces.SuscriptionDaoI;
import com.continent.persistencia.modelos.Suscription;
import com.continent.web.dto.CanalDTO;
import com.continent.web.dto.OperadorDTO;
import com.continent.web.dto.ServicioDTO;
import com.continent.web.dto.SuscriptionDTO;
import com.continent.web.dto.SuscriptionWSDTO;
import com.continent.web.servicios.interfaces.IServicioSuscripcion;
import com.continent.web.utils.MapperUtils;

@Service
public class ServicioSuscripcion extends ServicioGenerico<SuscriptionDTO,Suscription> implements IServicioSuscripcion{

	@Autowired
	ServicioCanal sc;
	
	@Autowired
	ServicioOperador so;
	
	@Autowired
	ServicioServicios ss;
	
	public ServicioSuscripcion() {
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
		return "";
	}
	
	public List<SuscriptionDTO> buscaSusWebser(int shortcode, String msIsdn,int idEstado)
	{
		List<Suscription> listaEntity= ((SuscriptionDaoI) this.getDaoObject()).buscaSusWebser(shortcode, msIsdn,idEstado);
		List<SuscriptionDTO> listaEntityDTO = new ArrayList<SuscriptionDTO>();
		MapperUtils.map(dozerMapper, listaEntity, listaEntityDTO, SuscriptionDTO.class);
		return listaEntityDTO;
		
	}
}
