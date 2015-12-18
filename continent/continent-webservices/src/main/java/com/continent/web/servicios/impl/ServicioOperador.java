package com.continent.web.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.continent.persistencia.dao.interfaces.OperadorDaoI;
import com.continent.persistencia.modelos.Operadore;
import com.continent.web.dto.OperadorDTO;
import com.continent.web.servicios.interfaces.IServicioOperador;
import com.continent.web.utils.MapperUtils;

@Service
public class ServicioOperador extends ServicioGenerico<OperadorDTO,Operadore> implements IServicioOperador{

	public ServicioOperador() {
		super(OperadorDTO.class,Operadore.class);
	}

	@Autowired
		public void setDaoObject(OperadorDaoI daoObject) {
			super.setDaoObject(daoObject);
		}
	@Autowired
		public void setDozerMapper(DozerBeanMapper dozerMapper) {
			super.setDozerMapper(dozerMapper);
		}

	@Override
	public List<OperadorDTO> listar(int idOperador,int idEstado) {
		List<Operadore> listaEntity= ((OperadorDaoI) this.getDaoObject()).BuscarOperadador(idOperador, idEstado);
		List<OperadorDTO> listaEntityDTO = new ArrayList<OperadorDTO>();
		MapperUtils.map(dozerMapper, listaEntity, listaEntityDTO, OperadorDTO.class);
		return listaEntityDTO;
	}
	
}
