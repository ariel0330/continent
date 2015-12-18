package com.continent.web.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.continent.persistencia.dao.interfaces.SmschatsendDaoI;
import com.continent.persistencia.modelos.Smschatsend;
import com.continent.web.dto.SmschatsendDTO;
import com.continent.web.servicios.interfaces.IServicioSmschatsend;
import com.continent.web.utils.MapperUtils;

@Service
public class ServicioSmschatsend extends ServicioGenerico<SmschatsendDTO,Smschatsend> implements IServicioSmschatsend{

	
	public ServicioSmschatsend() {
		super(SmschatsendDTO.class,Smschatsend.class);
	}

	@Autowired
		public void setDaoObject(SmschatsendDaoI daoObject) {
			super.setDaoObject(daoObject);
		}
	@Autowired
		public void setDozerMapper(DozerBeanMapper dozerMapper) {
			super.setDozerMapper(dozerMapper);
		}
	
	@Override
	public List<SmschatsendDTO> listar(int operadorID,int clubID,String fecha) {
		List<Smschatsend> listaEntity= ((SmschatsendDaoI) this.getDaoObject()).buscarSMS(operadorID, clubID,fecha);
		List<SmschatsendDTO> listaEntityDTO = new ArrayList<SmschatsendDTO>();
		MapperUtils.map(dozerMapper, listaEntity, listaEntityDTO, SmschatsendDTO.class);
		return listaEntityDTO;
	}

}
