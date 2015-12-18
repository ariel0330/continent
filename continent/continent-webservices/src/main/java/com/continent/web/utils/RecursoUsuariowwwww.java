//package com.continent.web.utils;
//
//import java.io.IOException;
//import java.util.List;
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.GET;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//
//import org.codehaus.jackson.JsonGenerationException;
//import org.codehaus.jackson.map.JsonMappingException;
//import org.codehaus.jackson.map.ObjectMapper;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import com.continent.web.dto.RoleDTO;
//import com.continent.web.dto.UserDTO;
//import com.continent.web.servicios.interfaces.IServicioUsuario;
//
//
//@Component
//@Path("/user")
//public class RecursoUsuariowwwww
//{
//
//	private final Logger logger = LoggerFactory.getLogger(this.getClass());
//
//
//
//	@Autowired
//	private IServicioUsuario servicioUsuarios;
//	
//
//
//	@Autowired
//	private ObjectMapper mapper;
//
//
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	public String listaUsuarios() throws JsonGenerationException, JsonMappingException, IOException
//	{
//		this.logger.info("list()");
//
//		List<UserDTO> listaUsuarios=servicioUsuarios.listar();
////		ObjectWriter viewWriter;
////		if (this.isAdmin()) {
////			viewWriter = this.mapper.writerWithView(JsonViews.Admin.class);
////		} else {
////			viewWriter = this.mapper.writerWithView(JsonViews.Admin.class);
////		}
////		List<entity> allEntries = this.entityDao.findAll();
////		    String usuarios = viewWriter.writeValueAsString(listaUsuarios);
//			String usuarios = mapper.writeValueAsString(listaUsuarios);
//		return usuarios;
//	}
//	
//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
//	@Path("{id}")
//	public UserDTO read(@PathParam("id") Long id)
//	{
//		this.logger.info("read(id)");
//
//	
//		UserDTO entity = servicioUsuarios.obtenerPorPK(id.intValue());
//		return entity;
//	}
//	
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Path("{id}")
//	public UserDTO update(@PathParam("id") Long id, UserDTO entity)
//	{
//		this.logger.info("update(): " + entity);
//		return this.servicioUsuarios.save(entity);
//	}
//	
//	@POST
//	@Produces(MediaType.APPLICATION_JSON)
//	@Consumes(MediaType.APPLICATION_JSON)
//	public UserDTO create(UserDTO entity)
//	{
//		this.logger.info("create(): " + entity);
//		RoleDTO rol = new RoleDTO();
//		rol.setId(entity.getIdRol());
//		entity.getRoles().add(rol);
//		return this.servicioUsuarios.save(entity);
//	}
//
//}