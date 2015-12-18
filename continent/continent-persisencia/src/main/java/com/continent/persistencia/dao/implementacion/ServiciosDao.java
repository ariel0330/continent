package com.continent.persistencia.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.continent.persistencia.dao.interfaces.ServiciosDaoI;
import com.continent.persistencia.modelos.Estado;
import com.continent.persistencia.modelos.Servicio;

@Repository
public class ServiciosDao extends GenericDao<Servicio> implements ServiciosDaoI {
	
	public ServiciosDao(){
		super(Servicio.class);
	}
	
	@Override
	public List<Servicio> BuscarServicio(int idServicio, int idEstado) {
			
			
		    CriteriaBuilder builder = em.getCriteriaBuilder();
		    CriteriaQuery<Servicio> query = builder.createQuery(Servicio.class);
		    Root<Servicio> servicio = query.from(Servicio.class);
		    
		    Join<Servicio, Estado> estadoJoin = servicio.join("estadoBean");
		   
		    
		    List<Predicate> conditions = new ArrayList<Predicate>();
		    if(idEstado>0)
		    conditions.add(builder.equal(estadoJoin.get("idEstado"), idEstado));
		    if(idServicio>0)
			    conditions.add(builder.equal(servicio.get("shortcode"), idServicio));

		    TypedQuery<Servicio> typedQuery = em.createQuery(query
		            .select(servicio)
		            .where(conditions.toArray(new Predicate[] {}))
		    );
		    return typedQuery.getResultList();
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Servicio> BuscarServicio() {
//			
//		NOT EXISTS
//		(
//		  SELECT 1  
//		  FROM contrata_area CA
//		  WHERE ca.cod_area = u.cod_unicom
//		)
		final StringBuilder sql = new StringBuilder("SELECT e FROM Servicio e where NOT EXISTS ( Select cs from ClubesServicio cs where cs.servicio_id=e.shortcode)");
		final Query query = this.em.getEntityManagerFactory() 
		.createEntityManager().createQuery(sql.toString());
		//query.setParameter("emision",1);
		return (List<Servicio>) query.getResultList(); 
		} 


	
	
}

