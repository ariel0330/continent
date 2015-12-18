package com.continent.persistencia.dao.implementacion;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.continent.persistencia.dao.interfaces.SmschatsendDaoI;
import com.continent.persistencia.modelos.Smschatsend;

@Repository
public class SmschatsendDao extends GenericDao<Smschatsend> implements SmschatsendDaoI{

	
	public SmschatsendDao(){
		super(Smschatsend.class);
	}
	
	public List<Smschatsend> buscarSMS(int operadorID,int clubID,String fecha) { 
		
		
		final StringBuilder sql = new StringBuilder("select e from ").append( 
				type.getSimpleName())
						.append(" e   ")
						;
				if(clubID>0)
				sql.append("join e.servicio.clubesServicios sr");
				
				if(operadorID>0 || clubID>0 || (fecha!=null && !fecha.equals("")))
					sql.append(" where ");
					
				if(operadorID>0)
					sql.append("e.cliente.operadore.smscId=:operadorID");
				
				if(clubID>0)
				{
					String cadenaAux=" sr.clube.clubId=:clubID ";
					if(!sql.toString().endsWith(" where "))
					{
						sql.append(" and ");
					}
					sql.append(cadenaAux);
				}
				
				
				if(fecha!=null && !fecha.equals(""))
				{

						String cadenaAux=" DATE_FORMAT(e.tsSend, '%d/%m/%Y')=:fecha";
						if(!sql.toString().endsWith(" where "))
						{
							sql.append(" and ");
						}
						sql.append(cadenaAux);

				}
					
				
				final Query query = this.em.getEntityManagerFactory() 
				.createEntityManager().createQuery(sql.toString());
				if(operadorID>0)
				query.setParameter("operadorID", operadorID);
				if(clubID>0)
				query.setParameter("clubID", clubID);
				
				
				if(fecha!=null && !fecha.equals(""))
				{
				
						query.setParameter("fecha", fecha);
				}
				return (List<Smschatsend>) query.getResultList(); 
				
				
//	    CriteriaBuilder builder = em.getCriteriaBuilder();
//	    CriteriaQuery<Smschatsend> query = builder.createQuery(Smschatsend.class);
//	    Root<Smschatsend> sms = query.from(Smschatsend.class);
//	    Join<Smschatsend, Cliente> clienteJoin = sms.join("cliente");
//	    Join<Cliente, Operadore> operadorJoin = clienteJoin.join("operadore");
//	    Join<Smschatsend, Servicio> servicioJoin = sms.join("servicio");
//	    Join<Servicio, ClubesServicio> clubServicioJoin = servicioJoin.join("clubesServicios");
//	    Join<ClubesServicio, Clube> clubJoin = clubServicioJoin.join("clube");
//	   
//	    
//	    List<Predicate> conditions = new ArrayList<Predicate>();
//	    if(operadorID>0)
//	    conditions.add(builder.equal(operadorJoin.get("smscId"), operadorID));
//	    if(clubID>0)
//		    conditions.add(builder.equal(clubJoin.get("clubId"), clubID));
//
//
//	    TypedQuery<Smschatsend> typedQuery = em.createQuery(query
//	            .select(sms)
//	            .where(conditions.toArray(new Predicate[] {}))
//	    );
//	    return typedQuery.getResultList();
}
}
