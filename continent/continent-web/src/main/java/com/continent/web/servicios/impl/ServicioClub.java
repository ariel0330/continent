package com.continent.web.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.continent.persistencia.dao.interfaces.ClubDaoI;
import com.continent.persistencia.modelos.Clube;
import com.continent.web.dto.ClubDTO;
import com.continent.web.servicios.interfaces.IServicioClub;
import com.continent.web.utils.MapperUtils;

@Service
public class ServicioClub extends ServicioGenerico<ClubDTO,Clube> implements IServicioClub{

	
	public ServicioClub() {
		super(ClubDTO.class,Clube.class);
	}

	@Autowired
		public void setDaoObject(ClubDaoI daoObject) {
			super.setDaoObject(daoObject);
		}
	@Autowired
		public void setDozerMapper(DozerBeanMapper dozerMapper) {
			super.setDozerMapper(dozerMapper);
		}
	
	@Override
	public List<ClubDTO> listar(int idClub,int idEstado) {
		List<Clube> listaEntity= ((ClubDaoI) this.getDaoObject()).BuscarClub(idClub, idEstado);
		List<ClubDTO> listaEntityDTO = new ArrayList<ClubDTO>();
		MapperUtils.map(dozerMapper, listaEntity, listaEntityDTO, ClubDTO.class);
		return listaEntityDTO;
	}

}
