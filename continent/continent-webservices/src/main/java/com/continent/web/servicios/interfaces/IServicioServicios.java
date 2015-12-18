package com.continent.web.servicios.interfaces;

import java.util.List;

import com.continent.web.dto.ServicioDTO;


public interface IServicioServicios extends IServicioGenerico<ServicioDTO>{

	public List<ServicioDTO> listar(int idServicio,int idEstado);
}
