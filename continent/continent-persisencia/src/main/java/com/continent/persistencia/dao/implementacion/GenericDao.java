package com.continent.persistencia.dao.implementacion;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.continent.persistencia.dao.interfaces.GenericDaoI;

@Transactional
public class GenericDao<T> implements GenericDaoI<T>{

	@PersistenceContext(type=PersistenceContextType.EXTENDED)
	protected EntityManager em;

//	private Logger logger = Logger.getLogger(GenericDao.class);
	
	protected Class<T> type;
	public GenericDao(Class<T> entityClass){
		this.type = entityClass;
	}

	
	@Transactional(propagation = Propagation.REQUIRED)  
	public T insert(final T t) { 
		//this.em.flush();
		this.em.persist(t); 
		return t;
	} 

	@Transactional(readOnly = true)  
	public T findByPK(final Object id) { 
		return this.em.find(type, id); 
	} 
	
    @SuppressWarnings("unchecked")
	@Transactional(readOnly = true)  
    public List<T> getAll() {  
  
        final StringBuilder sql = new StringBuilder("select c from ").append(  
                type.getSimpleName()).append(" c");  
        final Query query = this.em.getEntityManagerFactory() 
        		.createEntityManager().createQuery(sql.toString());
        return (List<T>) query.getResultList(); 
        		//(List<T>) getJpaTemplate().find(sql.toString());  
  
    }  
	
	
//	@SuppressWarnings("unchecked")
//	@Transactional(readOnly = true)  
//	public List<T> getAllByEstado(long estado) { 
//	final StringBuilder sql = new StringBuilder("select e from ").append( 
//	type.getSimpleName()).append(" e where estado =:estado");
//	final Query query = this.em.getEntityManagerFactory() 
//	.createEntityManager().createQuery(sql.toString());
//	query.setParameter("estado", BigDecimal.valueOf(estado));
//	return (List<T>) query.getResultList(); 
//	} 


	@Transactional(propagation = Propagation.REQUIRED)  
	public void remove(final Object object) { 
		this.em.remove(findByPK(object)); 
	} 


	@Transactional(propagation = Propagation.REQUIRED)  
	public void update(final T object) { 
		this.em.merge(object); 
	} 


	@SuppressWarnings("unchecked")
	@Transactional
	public T save(Object entity)
	{
		return (T) this.em.merge(entity);
	}

	
	





	
	
}
