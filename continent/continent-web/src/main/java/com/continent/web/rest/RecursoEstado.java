package com.continent.web.rest;

import java.io.IOException;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.continent.web.dto.EstadoDTO;
import com.continent.web.servicios.interfaces.IServicioEstados;


@Component
@Path("/estado")
public class RecursoEstado
{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());



	@Autowired
	private IServicioEstados servicio;
	




	@Autowired
	private ObjectMapper mapper;


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listar() throws JsonGenerationException, JsonMappingException, IOException
	{
		this.logger.info("list()");

		List<EstadoDTO> lista=servicio.listar();
			String usuarios = mapper.writeValueAsString(lista);
		return usuarios;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public EstadoDTO read(@PathParam("id") Long id)
	{
		this.logger.info("read(id)");

	
		EstadoDTO entity = servicio.obtenerPorPK(id.intValue());
		return entity;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public EstadoDTO update(@PathParam("id") Long id, EstadoDTO entity)
	{
		this.logger.info("update(): " + entity);
		return this.servicio.save(entity);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public EstadoDTO create(EstadoDTO entity)
	{
		this.logger.info("create(): " + entity);
		return this.servicio.save(entity);
	}

}