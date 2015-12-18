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

import com.continent.web.dto.ClubDTO;
import com.continent.web.servicios.interfaces.IServicioClub;


@Component
@Path("/club")
public class RecursoClub
{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());



	@Autowired
	private IServicioClub servicioClub;
	


	@Autowired
	private ObjectMapper mapper;


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listar(@Context UriInfo info) throws JsonGenerationException, JsonMappingException, IOException
	{
		this.logger.info("list()");
		String  idClub = info.getQueryParameters().getFirst("idClub");
		String  idEstado = info.getQueryParameters().getFirst("idEstado");
		List<ClubDTO> lista=servicioClub.listar(Integer.parseInt(idClub),Integer.parseInt(idEstado));
			String usuarios = mapper.writeValueAsString(lista);
		return usuarios;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ClubDTO read(@PathParam("id") Long id)
	{
		this.logger.info("read(id)");

	
		ClubDTO entity = servicioClub.obtenerPorPK(id.intValue());
		return entity;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public ClubDTO update(@PathParam("id") Long id, ClubDTO entity)
	{
		this.logger.info("update(): " + entity);
		return this.servicioClub.save(entity);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ClubDTO create(ClubDTO entity)
	{
		this.logger.info("create(): " + entity);
		return this.servicioClub.save(entity);
	}

}