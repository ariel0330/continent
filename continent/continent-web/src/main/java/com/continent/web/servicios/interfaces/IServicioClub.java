package com.continent.web.servicios.interfaces;

import java.util.List;

import com.continent.web.dto.ClubDTO;

public interface IServicioClub extends IServicioGenerico<ClubDTO> {

	public List<ClubDTO> listar(int idClub,int idEstado);
}
