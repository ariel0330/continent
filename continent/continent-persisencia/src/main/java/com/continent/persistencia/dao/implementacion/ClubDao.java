package com.continent.persistencia.dao.implementacion;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.continent.persistencia.dao.interfaces.ClubDaoI;
import com.continent.persistencia.modelos.Clube;
import com.continent.persistencia.modelos.Estado;
import com.continent.persistencia.modelos.Operadore;

@Repository
public class ClubDao extends GenericDao<Clube> implements ClubDaoI {
	
	public ClubDao(){
		super(Clube.class);
	}
	
	@Override
	public List<Clube> BuscarClub(int idClube, int idEstado) {
			
			
		    CriteriaBuilder builder = em.getCriteriaBuilder();
		    CriteriaQuery<Clube> query = builder.createQuery(Clube.class);
		    Root<Clube> clube = query.from(Clube.class);
		    
		    Join<Operadore, Estado> estadoJoin = clube.join("estadoBean");
		   

		    List<Predicate> conditions = new ArrayList<Predicate>();
		    if(idEstado>0)
		    conditions.add(builder.equal(estadoJoin.get("idEstado"), idEstado));
		    if(idClube>0)
			    conditions.add(builder.equal(clube.get("clubId"), idClube));

		    TypedQuery<Clube> typedQuery = em.createQuery(query
		            .select(clube)
		            .where(conditions.toArray(new Predicate[] {}))
		    );
		    return typedQuery.getResultList();
	}
}

