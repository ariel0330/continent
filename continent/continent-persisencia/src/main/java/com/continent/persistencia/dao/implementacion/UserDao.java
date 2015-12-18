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

import com.continent.persistencia.dao.interfaces.UserDaoI;
import com.continent.persistencia.modelos.Estado;
import com.continent.persistencia.modelos.Role;
import com.continent.persistencia.modelos.User;

@Repository
public class UserDao extends GenericDao<User> implements UserDaoI {

	public UserDao() {
		super(User.class);
	}



	public List<User> BuscarUsuarios(int idPerfil,int idEstado) { 
		
		
	    CriteriaBuilder builder = em.getCriteriaBuilder();
	    CriteriaQuery<User> query = builder.createQuery(User.class);
	    Root<User> usuario = query.from(User.class);
	    Join<User, Estado> estadoJoin = usuario.join("estadoBean");
	    Join<User, Role> roleJoin = usuario.join("roles");

	    List<Predicate> conditions = new ArrayList<Predicate>();
	    if(idEstado>0)
	    conditions.add(builder.equal(estadoJoin.get("idEstado"), idEstado));
	    if(idPerfil>0)
		    conditions.add(builder.equal(roleJoin.get("id"), idPerfil));

	    TypedQuery<User> typedQuery = em.createQuery(query
	            .select(usuario)
	            .where(conditions.toArray(new Predicate[] {}))
	    );
	    return typedQuery.getResultList();
}
}