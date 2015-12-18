package com.continent.web.servicios.impl;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;

import com.continent.web.servicios.interfaces.IServicioGenerico;
import com.continent.web.utils.MapperUtils;

public class ServicioGenerico<T, U> implements IServicioGenerico<T> {

	protected DozerBeanMapper dozerMapper;
	protected Class<T> entityDTO;
	protected Class<U> entityBD;
	protected Object daoObject;

	public ServicioGenerico(Class<T> entityClass, Class<U> entityBD) {
		this.entityDTO = entityClass;
		this.entityBD = entityBD;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> listar() {
		try {
			Method metodo = daoObject.getClass().getMethod("getAll");
			List<U> listaUsua = (List<U>) metodo.invoke(daoObject);
			List<T> listaUsuariosDTO = new ArrayList<T>();
			MapperUtils
					.map(dozerMapper, listaUsua, listaUsuariosDTO, entityDTO);
			return listaUsuariosDTO;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T obtenerPorPK(Object pk) {
		try {
			Method metodo = daoObject.getClass().getMethod("findByPK",
					Object.class);
			U usuariobean = (U) metodo.invoke(daoObject, pk);
			T usuario;
			usuario = MapperUtils.map(dozerMapper, usuariobean, entityDTO);
			return usuario;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T save(T entity) {
		try {
			U usuariobean = MapperUtils.map(dozerMapper, entity, entityBD);
			Method metodo = daoObject.getClass()
					.getMethod("save", Object.class);
			usuariobean = (U) metodo.invoke(daoObject, usuariobean);
			T usuario = MapperUtils.map(dozerMapper, usuariobean, entityDTO);
			return usuario;
		} catch (Exception e) {
			return null;
		}
	}

	public DozerBeanMapper getDozerMapper() {
		return dozerMapper;
	}

	public void setDozerMapper(DozerBeanMapper dozerMapper) {
		this.dozerMapper = dozerMapper;
	}

	public Object getDaoObject() {
		return daoObject;
	}

	public void setDaoObject(Object daoObject) {
		this.daoObject = daoObject;
	}

}
