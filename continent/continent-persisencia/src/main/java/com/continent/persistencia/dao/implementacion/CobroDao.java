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

import com.continent.persistencia.dao.interfaces.CobroDaoI;
import com.continent.persistencia.modelos.Cliente;
import com.continent.persistencia.modelos.Clube;
import com.continent.persistencia.modelos.ClubesServicio;
import com.continent.persistencia.modelos.Cobro;
import com.continent.persistencia.modelos.Operadore;
import com.continent.persistencia.modelos.Servicio;

@Repository
public class CobroDao extends GenericDao<Cobro> implements CobroDaoI {
	
	public CobroDao(){
		super(Cobro.class);
	}

	public List<Cobro> buscarCobro(int operadorID,int clubID)
	{
	CriteriaBuilder builder = em.getCriteriaBuilder();
    CriteriaQuery<Cobro> query = builder.createQuery(Cobro.class);
    Root<Cobro> cobro = query.from(Cobro.class);
    Join<Cobro, Cliente> clienteJoin = cobro.join("cliente");
    Join<Cliente, Operadore> operadorJoin = clienteJoin.join("operadore");
    Join<Cobro, Servicio> servicioJoin = cobro.join("servicio");
    Join<Servicio, ClubesServicio> clubServicioJoin = servicioJoin.join("clubesServicios");
    Join<ClubesServicio, Clube> clubJoin = clubServicioJoin.join("clube");
   
    
    List<Predicate> conditions = new ArrayList<Predicate>();
    if(operadorID>0)
    conditions.add(builder.equal(operadorJoin.get("smscId"), operadorID));
    if(clubID>0)
	    conditions.add(builder.equal(clubJoin.get("clubId"), clubID));


    TypedQuery<Cobro> typedQuery = em.createQuery(query
            .select(cobro)
            .where(conditions.toArray(new Predicate[] {}))
    );
    return typedQuery.getResultList();
}
}

