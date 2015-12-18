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
import org.springframework.security.crypto.password.StandardPasswordEncoder;
import org.springframework.stereotype.Component;

import com.continent.web.dto.RoleDTO;
import com.continent.web.dto.UserDTO;
import com.continent.web.servicios.interfaces.IServicioUsuario;


@Component
@Path("/user")
public class RecursoUsuario
{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());



	@Autowired
	private IServicioUsuario servicioUsuarios;
	
	@Autowired
	StandardPasswordEncoder encoder;

	@Autowired
	private ObjectMapper mapper;


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listaUsuarios(@Context UriInfo info) throws JsonGenerationException, JsonMappingException, IOException 
	{
		this.logger.info("list()");
		String  idPerfil = info.getQueryParameters().getFirst("idPerfil");
		String  idEstado = info.getQueryParameters().getFirst("idEstado");
		
		List<UserDTO> listaUsuarios=servicioUsuarios.listar(Integer.parseInt(idPerfil),Integer.parseInt(idEstado));
//		RecursoReporte.generaReporte(listaUsuarios);
			String usuarios = mapper.writeValueAsString(listaUsuarios);
		return usuarios;
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public UserDTO read(@PathParam("id") Long id,@Context UriInfo info) 
	{
		String loginID = info.getQueryParameters().getFirst("loginID");
		this.logger.info("read(id)"+loginID);
		UserDTO entity = servicioUsuarios.obtenerPorPK(id.intValue());
		entity.setPassword("12345678");
		return entity;
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{id}")
	public UserDTO update(@PathParam("id") Long id, UserDTO entity) 
	{
		this.logger.info("update(): " + entity);
		if(!entity.getPassword().equals("12345678"))
			entity.setPassword(encoder.encode(entity.getPassword()));
		else
		{
			UserDTO entity2 = servicioUsuarios.obtenerPorPK(entity.getId());
			entity.setPassword(entity2.getPassword());
		}
		return this.servicioUsuarios.save(entity);
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public UserDTO create(UserDTO entity) 
	{
		this.logger.info("create(): " + entity);
		entity.getEstadoBean().setIdEstado(1);
		RoleDTO rol = new RoleDTO();
		rol.setId(entity.getIdRol());
		entity.getRoles().add(rol);
//		StandardPasswordEncoder encoder = new StandardPasswordEncoder("ThisIsASecretSoChangeMe");
		entity.setPassword(encoder.encode(entity.getPassword()));
		return this.servicioUsuarios.save(entity);
	}

}