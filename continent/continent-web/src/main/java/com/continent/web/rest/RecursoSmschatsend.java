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

import com.continent.web.dto.SmschatsendDTO;
import com.continent.web.servicios.interfaces.IServicioSmschatsend;


@Component
@Path("/smsSend")
public class RecursoSmschatsend
{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());



	@Autowired
	private IServicioSmschatsend servicioSmsChatSend;
	


	@Autowired
	private ObjectMapper mapper;


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listar(@Context UriInfo info) throws JsonGenerationException, JsonMappingException, IOException
	{
		this.logger.info("list()");
		String  operadorID = info.getQueryParameters().getFirst("operadorID");
		String  clubID = info.getQueryParameters().getFirst("clubID");
		String  fecha = info.getQueryParameters().getFirst("fecha");


		List<SmschatsendDTO> lista=servicioSmsChatSend.listar(Integer.parseInt(operadorID),Integer.parseInt(clubID),fecha);
			String usuarios = mapper.writeValueAsString(lista);
		return usuarios;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public SmschatsendDTO read(@PathParam("id") Long id)
	{
		this.logger.info("read(id)");

	
		SmschatsendDTO entity = servicioSmsChatSend.obtenerPorPK(id.intValue());
		return entity;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public SmschatsendDTO update(@PathParam("id") Long id, SmschatsendDTO entity)
	{
		this.logger.info("update(): " + entity);
		return this.servicioSmsChatSend.save(entity);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public SmschatsendDTO create(SmschatsendDTO entity)
	{
		this.logger.info("create(): " + entity);
		return this.servicioSmsChatSend.save(entity);
	}

}