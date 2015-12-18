package com.continent.persistencia.dao.interfaces;


import java.util.List;

public interface GenericDaoI <T>{

	
	
	T findByPK(Object id); 

	void update(T object); 

	void remove(Object object); 

	T insert(T object); 
	
	public T save(T entity);

//	List<T> getPaginated(int startPosition, int maxResult); 

//	List<T> getOrderedPaginated(int startPosition, int maxResult, String order, int dir);
//	public List<T> getAllByEstado(long startPosition);
//	public List<T> getAllByEstatus(long startPosition);
	public List<T> getAll();
//	public Date getDate();
//	public Integer Count();
	//solo para los archivos
//	public Long CountbyEmisionAndEstado(long emision,long estado);
//	public List<T> getAllbyEmisionP(String emision, final int startPosition, final int maxResult);
//	public List<T> getPerfilesUsuario(String codUser);
//	public Long searchCount(String emision, int startPosition, int maxResult, T registro);
//	public List<T> search(String emision, final int start, final int maxresult, T registro);
}
