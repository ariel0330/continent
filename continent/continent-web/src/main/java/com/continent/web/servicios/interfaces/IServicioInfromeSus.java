package com.continent.web.servicios.interfaces;

import java.util.List;

import com.continent.web.dto.SuscriptionDTO;

public interface IServicioInfromeSus extends IServicioGenerico<SuscriptionDTO>{
	
	
	public List<SuscriptionDTO> listar(int operadorID,int clubID,int estadoSuscripcion,int idCanal,String fecha);
	
	

}
