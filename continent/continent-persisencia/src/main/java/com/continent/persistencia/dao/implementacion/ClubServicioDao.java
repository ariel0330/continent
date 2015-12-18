package com.continent.persistencia.dao.implementacion;

import org.springframework.stereotype.Repository;

import com.continent.persistencia.dao.interfaces.ClubServicioI;
import com.continent.persistencia.modelos.ClubesServicio;

@Repository
public class ClubServicioDao extends GenericDao<ClubesServicio> implements ClubServicioI {
	
	public ClubServicioDao(){
		super(ClubesServicio.class);
	}
	
//	@Override
//	public List<Clube> BuscarClub(int idClube, int idEstado) {
//			
//			
//		    CriteriaBuilder builder = em.getCriteriaBuilder();
//		    CriteriaQuery<Clube> query = builder.createQuery(Clube.class);
//		    Root<Clube> clube = query.from(Clube.class);
//		    
//		    Join<Operadore, Estado> estadoJoin = clube.join("estadoBean");
//		   
//
//		    List<Predicate> conditions = new ArrayList<Predicate>();
//		    if(idEstado>0)
//		    conditions.add(builder.equal(estadoJoin.get("idEstado"), idEstado));
//		    if(idClube>0)
//			    conditions.add(builder.equal(clube.get("clubId"), idClube));
//
//		    TypedQuery<Clube> typedQuery = em.createQuery(query
//		            .select(clube)
//		            .where(conditions.toArray(new Predicate[] {}))
//		    );
//		    return typedQuery.getResultList();
//	}
}

