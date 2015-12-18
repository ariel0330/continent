package com.continent.web.servicios.interfaces;

import java.util.List;

import com.continent.web.dto.CobroDTO;

public interface IServicioCobro extends IServicioGenerico<CobroDTO> {

	public List<CobroDTO> listar(int operadorID,int clubID);
}
