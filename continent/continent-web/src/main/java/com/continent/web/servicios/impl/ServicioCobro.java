package com.continent.web.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.continent.persistencia.dao.interfaces.CobroDaoI;
import com.continent.persistencia.modelos.Cobro;
import com.continent.web.dto.CobroDTO;
import com.continent.web.servicios.interfaces.IServicioCobro;
import com.continent.web.utils.MapperUtils;

@Service
public class ServicioCobro extends ServicioGenerico<CobroDTO,Cobro> implements IServicioCobro{

	
	public ServicioCobro() {
		super(CobroDTO.class,Cobro.class);
	}

	@Autowired
		public void setDaoObject(CobroDaoI daoObject) {
			super.setDaoObject(daoObject);
		}
	@Autowired
		public void setDozerMapper(DozerBeanMapper dozerMapper) {
			super.setDozerMapper(dozerMapper);
		}
	
	@Override
	public List<CobroDTO> listar(int operadorID,int clubID){
		List<Cobro> listaEntity= ((CobroDaoI) this.getDaoObject()).buscarCobro(operadorID, clubID);
		List<CobroDTO> listaEntityDTO = new ArrayList<CobroDTO>();
		MapperUtils.map(dozerMapper, listaEntity, listaEntityDTO, CobroDTO.class);
		return listaEntityDTO;
	}

}
