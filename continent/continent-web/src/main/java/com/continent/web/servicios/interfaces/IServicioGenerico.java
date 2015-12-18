package com.continent.web.servicios.interfaces;

import java.util.List;

public interface IServicioGenerico<T> {
	
	
	public List<T> listar() ;
	
	public T obtenerPorPK(Object pk) ;
	
	public T save(T entity) ;

}
