package com.continent.web.servicios.interfaces;

import java.util.List;

import com.continent.web.dto.OperadorDTO;

public interface IServicioOperador extends IServicioGenerico<OperadorDTO>{

	public List<OperadorDTO> listar(int idOperador,int idEstado);
}
