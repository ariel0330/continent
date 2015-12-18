package com.continent.web.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
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

import com.continent.web.dto.OperadorDTO;
import com.continent.web.servicios.interfaces.IServicioOperador;


@Component
@Path("/operador")
public class RecursoOperador
{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());



	@Autowired
	private IServicioOperador servicioOperador;
	


	@Autowired
	private ObjectMapper mapper;


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listar(@Context UriInfo info) throws JsonGenerationException, JsonMappingException, IOException
	{
		this.logger.info("list()");
		String  idOperador = info.getQueryParameters().getFirst("idOperador");
		String  idEstado = info.getQueryParameters().getFirst("idEstado");

		List<OperadorDTO> lista=servicioOperador.listar(Integer.parseInt(idOperador),Integer.parseInt(idEstado));
			String usuarios = mapper.writeValueAsString(lista);
		return usuarios;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public OperadorDTO read(@PathParam("id") Long id)
	{
		this.logger.info("read(id)");

	
		OperadorDTO entity = servicioOperador.obtenerPorPK(id.intValue());
		return entity;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public OperadorDTO update(@PathParam("id") Long id, OperadorDTO entity)
	{
		this.logger.info("update(): " + entity);
		return this.servicioOperador.save(entity);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public OperadorDTO create(OperadorDTO entity)
	{
		this.logger.info("create(): " + entity);
		return this.servicioOperador.save(entity);
	}

}