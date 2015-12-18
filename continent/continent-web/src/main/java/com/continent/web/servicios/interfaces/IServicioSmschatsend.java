package com.continent.web.servicios.interfaces;

import java.util.List;

import com.continent.web.dto.SmschatsendDTO;

public interface IServicioSmschatsend extends IServicioGenerico<SmschatsendDTO> {
	

	public List<SmschatsendDTO> listar(int operadorID,int clubID,String fecha);
}
