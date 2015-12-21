package com.continent.persistencia;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.continent.persistencia.dao.interfaces.ClienteDaoI;
import com.continent.persistencia.dao.interfaces.SuscriptionDaoI;
import com.continent.persistencia.modelos.Cliente;
import com.continent.persistencia.modelos.Operadore;

import junit.framework.Assert;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class Tests {

	
	@Autowired
	SuscriptionDaoI suscriptionDao; 
	

	
	@Autowired
	ClienteDaoI clientedao; 
	
	
	
	
	@Test
	@Transactional
	public void Test()
	{
		
		Cliente cliente = new Cliente();
		cliente.setMsIsdn("50767899111");
		Operadore operadore = new Operadore();
		operadore.setSmscId(1);
		cliente.setOperadore(operadore );
		clientedao.save(cliente);
		Cliente cliente2 = clientedao.findByPK("50767899111");
//		ClienteWS entity = new ClienteWS();
//		entity.setMsIsdn("50767899111");
//		entity.setSmscId(1);
//		clientewsdao.save(entity);
//		
//		ClienteWS entity2 = clientewsdao.findByPK("50767899111");
//		
//		clientewsdao.save(entity2);
//		Assert.assertEquals(entity.getMsIsdn(), entity2.getMsIsdn());
		Operadore operadore2 = cliente2.getOperadore();
		System.out.println(operadore2.getNombre());
		Assert.assertEquals(cliente.getMsIsdn(), cliente2.getMsIsdn());

		
		
	}


}
