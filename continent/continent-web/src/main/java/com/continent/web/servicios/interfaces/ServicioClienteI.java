package com.continent.web.servicios.interfaces;

import java.util.List;

import com.continent.persistencia.modelos.Cliente;


public interface ServicioClienteI  {

	public void insertarCiente(Cliente cliente);
	
	public void actualizarClietne(Cliente cliente);
	
	public Cliente obtenerCliente(Cliente cliente);
	
	public List<Cliente> obtenerListaClintes(Cliente cliente);
	
	
}
