package com.continent.web.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
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

import com.continent.web.dto.SuscriptionWSDTO;
import com.continent.web.servicios.interfaces.IServicioSuscripcion;


@Component
@Path("/suscripcion")
public class RecursoSuscripcion
{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());



	@Autowired
	private IServicioSuscripcion servicioSuscripcion;
	


	@Autowired
	private ObjectMapper mapper;


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listar(@Context UriInfo info) throws JsonGenerationException, JsonMappingException, IOException
	{
		List<SuscriptionWSDTO> lista=servicioSuscripcion.listar();
			String usuarios = mapper.writeValueAsString(lista);
		return usuarios;
	}

	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public String create(SuscriptionWSDTO entity)
	{
		this.logger.info("create(): " + entity);
		String salida=servicioSuscripcion.validaSuscripcion(entity);
//		return this.servicioSuscripcion.save(entity);
		return salida;
	}

}