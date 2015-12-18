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

import com.continent.persistencia.dao.interfaces.OperadorDaoI;
import com.continent.persistencia.modelos.Estado;
import com.continent.persistencia.modelos.Operadore;

@Repository
public class OperadorDao extends GenericDao<Operadore> implements OperadorDaoI {
	
	public OperadorDao(){
		super(Operadore.class);
	}


	@Override
	public List<Operadore> BuscarOperadador(int idOperador, int idEstado) {
			
			
		    CriteriaBuilder builder = em.getCriteriaBuilder();
		    CriteriaQuery<Operadore> query = builder.createQuery(Operadore.class);
		    Root<Operadore> operador = query.from(Operadore.class);
		    
		    Join<Operadore, Estado> estadoJoin = operador.join("estadoBean");
		   

		    List<Predicate> conditions = new ArrayList<Predicate>();
		    if(idEstado>0)
		    conditions.add(builder.equal(estadoJoin.get("idEstado"), idEstado));
		    if(idOperador>0)
			    conditions.add(builder.equal(operador.get("smscId"), idOperador));

		    TypedQuery<Operadore> typedQuery = em.createQuery(query
		            .select(operador)
		            .where(conditions.toArray(new Predicate[] {}))
		    );
		    return typedQuery.getResultList();
	}


}

