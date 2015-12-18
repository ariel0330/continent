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

import com.continent.web.dto.ClienteDTO;
import com.continent.web.servicios.interfaces.IServicioCliente;


@Component
@Path("/cliente")
public class RecursoCliente
{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());



	@Autowired
	private IServicioCliente servicio;
	


	@Autowired
	private ObjectMapper mapper;


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listar() throws JsonGenerationException, JsonMappingException, IOException
	{
		this.logger.info("list()");

		List<ClienteDTO> lista=servicio.listar();
			String usuarios = mapper.writeValueAsString(lista);
		return usuarios;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ClienteDTO read(@PathParam("id") String id)
	{
		this.logger.info("read(id)");

	
		ClienteDTO entity = servicio.obtenerPorPK(id);
		return entity;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ClienteDTO update(@PathParam("id") Long id, ClienteDTO entity)
	{
		this.logger.info("update(): " + entity);
		return this.servicio.save(entity);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ClienteDTO create(ClienteDTO entity)
	{
		this.logger.info("create(): " + entity);
		return this.servicio.save(entity);
	}

}