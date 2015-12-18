package com.continent.web.servicios.impl;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.continent.persistencia.dao.interfaces.UserDaoI;
import com.continent.persistencia.modelos.User;
import com.continent.web.dto.UserDTO;
import com.continent.web.servicios.interfaces.IServicioUsuario;
import com.continent.web.utils.MapperUtils;

@Service
public class ServicioUsuario extends ServicioGenerico<UserDTO,User> implements IServicioUsuario{
	
	public ServicioUsuario() {
		super(UserDTO.class,User.class);
	}

	@Autowired
		public void setDaoObject(UserDaoI daoObject) {
			super.setDaoObject(daoObject);
		}
	@Autowired
		public void setDozerMapper(DozerBeanMapper dozerMapper) {
			super.setDozerMapper(dozerMapper);
		}

	
	@Override
	public List<UserDTO> listar(int idPerfil,int idEstado) {
		List<User> listaEntity= ((UserDaoI) this.getDaoObject()).BuscarUsuarios(idPerfil, idEstado);
		List<UserDTO> listaEntityDTO = new ArrayList<UserDTO>();
		MapperUtils.map(dozerMapper, listaEntity, listaEntityDTO, UserDTO.class);
		return listaEntityDTO;
	}

	
	
}
