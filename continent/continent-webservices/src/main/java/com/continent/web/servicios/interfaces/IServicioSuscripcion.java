package com.continent.web.servicios.interfaces;

import java.math.BigDecimal;
import java.util.List;

import com.continent.persistencia.modelos.Suscription;
import com.continent.web.dto.SuscriptionDTO;
import com.continent.web.dto.SuscriptionWSDTO;

public interface IServicioSuscripcion extends IServicioGenerico<SuscriptionDTO> {
	
	public String validaSuscripcion(SuscriptionWSDTO entity);
	
	public List<SuscriptionDTO> buscaSusWebser(int shortcode, String msIsdn,int idEstado);

}
