package com.continent.persistencia.dao.implementacion;

import org.springframework.stereotype.Repository;

import com.continent.persistencia.dao.interfaces.RoleDaoI;
import com.continent.persistencia.modelos.Role;

@Repository
public class RoleDao extends GenericDao<Role> implements RoleDaoI {
	
	public RoleDao(){
		super(Role.class);
	}
	

}

