package com.continent.web.servicios.interfaces;

import java.util.List;

import com.continent.web.dto.UserDTO;

public interface IServicioUsuario extends IServicioGenerico<UserDTO>{

	public List<UserDTO> listar(int idPerfil,int idEstado);

	
}
