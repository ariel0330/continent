package com.continent.web.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.continent.web.dto.SuscriptionDTO;
import com.continent.web.servicios.interfaces.IServicioInfromeSus;


@Component
@Path("/Infsus")
public class RecursoInformeSuscriptores
{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());



	@Autowired
	private IServicioInfromeSus servicioInfromeSus;
	


	@Autowired
	private ObjectMapper mapper;


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public String lista(@PathParam("id") int id,@Context UriInfo info) throws JsonGenerationException, JsonMappingException, IOException
	{
		String  operadorID = info.getQueryParameters().getFirst("operadorID");
		String  clubID = info.getQueryParameters().getFirst("clubID");
		String  idCanal = info.getQueryParameters().getFirst("idCanal");
		String fecha = info.getQueryParameters().getFirst("fecha");
		this.logger.info("list()");

		List<SuscriptionDTO> lista=servicioInfromeSus.listar(Integer.parseInt(operadorID), Integer.parseInt(clubID),id,Integer.parseInt(idCanal),fecha);

			String usuarios = mapper.writeValueAsString(lista);
		return usuarios;
	}
	
}