package com.continent.web.servicios.interfaces;

import com.continent.web.dto.SuscriptionWSDTO;

public interface IServicioSuscripcion extends IServicioGenerico<SuscriptionWSDTO> {
	
	public String validaSuscripcion(SuscriptionWSDTO entity);

}
