package com.continent.web.servicios.interfaces;

import java.util.List;

import com.continent.persistencia.modelos.Operadore;


public interface ServicioOperadorI  {

	public void insertarOperador(Operadore operador);
	
	public void actualizarOperador(Operadore operador);
	
	public Operadore obtenerOperador(Operadore operador);
	
	public List<Operadore> obtenerListaOperadores(Operadore operador);
	
	
}
