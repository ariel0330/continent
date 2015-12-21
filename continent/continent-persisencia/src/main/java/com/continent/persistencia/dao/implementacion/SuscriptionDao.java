package com.continent.persistencia.dao.implementacion;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.continent.persistencia.dao.interfaces.SuscriptionDaoI;
import com.continent.persistencia.modelos.Suscription;

@Repository
public class SuscriptionDao extends GenericDao<Suscription> implements SuscriptionDaoI {
	
	public SuscriptionDao(){
		super(Suscription.class);
	}
	

	
	
	@SuppressWarnings("unchecked")
	public List<Suscription> ReporteSuscriptiones(int operadorID,int clubID,int estadoSuscripcion,int idCanal,String fecha) { 
	

		
			final StringBuilder sql = new StringBuilder("select e from ").append( 
			type.getSimpleName())
					.append(" e   ")
					;
			if(clubID>0)
			sql.append("join e.servicio.clubesServicios sr");
			
			if(operadorID>0 || clubID>0 || idCanal>0 || estadoSuscripcion>0 ||  (fecha!=null && !fecha.equals("")))
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
			if (idCanal>0)
			{
			if(estadoSuscripcion==1)
			{
				String cadenaAux=" e.canal1.idCanal=:idCanal ";
				if(!sql.toString().endsWith(" where "))
				{
					sql.append(" and ");
				}
				sql.append(cadenaAux);
			}
			else
			{
				String cadenaAux=" e.canal2.idCanal=:idCanal ";
				if(!sql.toString().endsWith(" where "))
				{
					sql.append(" and ");
				}
				sql.append(cadenaAux);
			}
			}
			
			if(fecha!=null && !fecha.equals(""))
			{
				if(estadoSuscripcion==1)
				{
					String cadenaAux=" DATE_FORMAT(sus_ts, '%d/%m/%Y')=:fecha";
					if(!sql.toString().endsWith(" where "))
					{
						sql.append(" and ");
					}
					sql.append(cadenaAux);
				}
				else
				{
					String cadenaAux=" DATE_FORMAT(e.desTs, '%d/%m/%Y')=:fecha";
					if(!sql.toString().endsWith(" where "))
					{
						sql.append(" and ");
					}
					sql.append(cadenaAux);
				}

			}
				
			String cadenaAux=" e.estado.idEstado=:estado";
			if(!sql.toString().endsWith(" where "))
			{
				sql.append(" and ");
			}
			sql.append(cadenaAux);
			
			final Query query = this.em.getEntityManagerFactory() 
			.createEntityManager().createQuery(sql.toString());
			if(operadorID>0)
			query.setParameter("operadorID", operadorID);
			if(clubID>0)
			query.setParameter("clubID", clubID);
			if(idCanal>0)
			query.setParameter("idCanal", idCanal);
			query.setParameter("estado", estadoSuscripcion);
			if(fecha!=null && !fecha.equals(""))
			{
			
					query.setParameter("fecha", fecha);
			}
			return (List<Suscription>) query.getResultList(); 
	}

	
	@SuppressWarnings("unchecked")
	public List<Suscription> buscaSusWebser(int shortcode, String msIsdn,int idEstado) { 
	

		
			final StringBuilder sql = new StringBuilder("select e from ").append( 
			type.getSimpleName())
					.append(" e   ")
					;
				sql.append(" where ");
				sql.append("e.cliente.msIsdn=:msIsdn");
				sql.append(" and ");
				sql.append("e.servicio.shortcode=:shortcode");
				sql.append(" and ");
				sql.append("e.estado.idEstado=:idEstado");

			
			final Query query = this.em.getEntityManagerFactory() 
			.createEntityManager().createQuery(sql.toString());
			query.setParameter("msIsdn", msIsdn);
			query.setParameter("shortcode", shortcode);
			query.setParameter("idEstado", idEstado);

			return (List<Suscription>) query.getResultList(); 
	}

}

