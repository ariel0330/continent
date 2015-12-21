package com.continent.web.rest;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

import com.continent.web.dto.CanalDTO;
import com.continent.web.dto.ClienteDTO;
import com.continent.web.dto.EstadoDTO;
import com.continent.web.dto.OperadorDTO;
import com.continent.web.dto.ServicioDTO;
import com.continent.web.dto.SuscriptionDTO;
import com.continent.web.dto.SuscriptionWSDTO;
import com.continent.web.servicios.interfaces.IServicioCliente;
import com.continent.web.servicios.interfaces.IServicioSuscripcion;


@Component
@Path("/suscripcion")
public class RecursoSuscripcion
{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());



	@Autowired
	private IServicioSuscripcion servicioSuscripcion;
	
	@Autowired
	private IServicioCliente servicioCliente;

	


	@Autowired
	private ObjectMapper mapper;


	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String listar(@Context UriInfo info) throws JsonGenerationException, JsonMappingException, IOException
	{
		List<SuscriptionDTO> lista=servicioSuscripcion.listar();
			String usuarios = mapper.writeValueAsString(lista);
		return usuarios;
	}

	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@SuppressWarnings("unused")
	@Path("/alta")
	public String create(SuscriptionWSDTO entity) throws ParseException
	{
		
		SuscriptionDTO suscripcionDTO= new SuscriptionDTO();
		
		List<SuscriptionDTO> listasuscripcionDTO = servicioSuscripcion.buscaSusWebser(entity.getShortcode(), entity.getCliente().getMsIsdn(),1);
		if ( listasuscripcionDTO.size() <1)
		{
		ClienteDTO cliente = new ClienteDTO();
		cliente.setMsIsdn(entity.getCliente().getMsIsdn());
		
		OperadorDTO operadore = new OperadorDTO();
		operadore.setSmscId(entity.getCliente().getSmscId());
		cliente.setOperadore(operadore);
		suscripcionDTO.setCliente(cliente);
		
		ServicioDTO servicio= new ServicioDTO();
		servicio.setShortcode(entity.getShortcode());
		suscripcionDTO.setServicio(servicio);
		
		
		CanalDTO canal = new CanalDTO();
		canal.setIdCanal(entity.getSusUser());
		suscripcionDTO.setCanal2(canal);
		
		EstadoDTO estado = new EstadoDTO();
		estado.setIdEstado(1);
		suscripcionDTO.setEstado(estado);
		
		String salida=servicioSuscripcion.validaSuscripcion(entity);
		servicioCliente.save(cliente);
		cliente = servicioCliente.obtenerPorPK(entity.getCliente().getMsIsdn());
		suscripcionDTO.setCliente(cliente);
		SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
		
		suscripcionDTO.setFUltimoCobro(sdf.parse("12/31/2999"));
		suscripcionDTO.setSusTs(new Date());
		servicioSuscripcion.save(suscripcionDTO);
		}
		else
		{
			return "ya se encuentra suscrito al servicio";
		}
		
		return null;
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/baja")
	public String baja(SuscriptionWSDTO entity) throws ParseException
	{
		
		SuscriptionDTO suscripcionDTO= new SuscriptionDTO();
		
		List<SuscriptionDTO> listasuscripcionDTO = servicioSuscripcion.buscaSusWebser(entity.getShortcode(), entity.getCliente().getMsIsdn(),1);
		if ( listasuscripcionDTO.size() == 1 )
		{
		suscripcionDTO=listasuscripcionDTO.get(0);

		CanalDTO canal = new CanalDTO();
		canal.setIdCanal(entity.getDesUser());
		suscripcionDTO.setCanal1(canal);
		
		EstadoDTO estado = new EstadoDTO();
		estado.setIdEstado(2);
		suscripcionDTO.setEstado(estado);
		
		SimpleDateFormat sdf= new SimpleDateFormat("MM/dd/yyyy");
		suscripcionDTO.setDesTs(new Date());
		servicioSuscripcion.save(suscripcionDTO);
		}
		else
		{
			return "Usted no esta suscripto al servicio";
		}
		logger.info("Baja registro");
		return null;
	}
	
}