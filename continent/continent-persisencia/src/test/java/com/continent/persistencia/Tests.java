package com.continent.persistencia;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.continent.persistencia.dao.interfaces.ClienteDaoI;
import com.continent.persistencia.dao.interfaces.ClubServicioI;
import com.continent.persistencia.dao.interfaces.CobroDaoI;
import com.continent.persistencia.dao.interfaces.ServiciosDaoI;
import com.continent.persistencia.dao.interfaces.SmschatsendDaoI;
import com.continent.persistencia.dao.interfaces.SuscriptionDaoI;
import com.continent.persistencia.dao.interfaces.UserDaoI;
import com.continent.persistencia.modelos.Smschatsend;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class Tests {

	
	@Autowired
	SuscriptionDaoI suscriptionDao; 
	
	
	@Autowired
	CobroDaoI cobroDao; 
	
	@Autowired
	ClienteDaoI clientes; 

	@Autowired
	ServiciosDaoI servicioDao; 
	
	
	@Autowired
	UserDaoI usuario; 
	
	@Autowired
	ClubServicioI clubServicio; 
	
	@Autowired
	SmschatsendDaoI smschatsendDaoI;
	
	
	
	
//	@Test
//@Transactional
//public void test1() throws Exception {
//	List<Cliente> lista = clientes.getAll();
//	List<User> lista = usuario.BuscarUsuarios(1,1);
//	for ( User suscriptor : lista )
//	{
//		
//			System.err.println(suscriptor.toString());
//	}
//}
	
	
	
	@Test
//@Transactional
public void test1() throws Exception {
//	List<Cliente> lista = clientes.getAll();

	List<Smschatsend> lista = smschatsendDaoI.buscarSMS(1, 1,"01/07/2015");
	for ( Smschatsend suscriptor : lista )
	{
//		if(suscriptor.getServicio().getClubesServicios().size() == 1)
		{
			System.err.println("Cliente: "+suscriptor.getCliente().getMsIsdn()+" "
					         + "Operador: "+suscriptor.getCliente().getOperadore().getNombre()+
//					         " Fecha de Supscripcion: "+suscriptor.getSusTs()+
					         " Servicio de Alta: "+suscriptor.getServicio().getPalabraCorta()
					         +" al "+suscriptor.getServicio().getShortcode()+" Club: "+suscriptor.getServicio().getClubesServicios().get(0).getClube().getClubName()
					         );
		}
//		else
//			System.err.println(suscriptor.getServicio().getClubesServicios().size());
	}
}
	
	
	
//	@Test
////	@Transactional
//	public void test1() throws Exception {
////		List<Cliente> lista = clientes.getAll();
//	
//		List<Suscription> lista = suscriptionDao.ReporteSuscriptiones(2, 1, 1, 2 ,"2015-04-04");
//		for ( Suscription suscriptor : lista )
//		{
////			if(suscriptor.getServicio().getClubesServicios().size() == 1)
//			{
//				System.err.println("Cliente: "+suscriptor.getCliente().getMsIsdn()+" "
//						         + "Operador: "+suscriptor.getCliente().getOperadore().getNombre()+
//						         " Fecha de Supscripcion: "+suscriptor.getSusTs()+
//						         " Servicio de Alta: "+suscriptor.getServicio().getPalabraCorta()
//						         +" al "+suscriptor.getServicio().getShortcode()+" Club: "+suscriptor.getServicio().getClubesServicios().get(0).getClube().getClubName()
//						         );
//			}
////			else
////				System.err.println(suscriptor.getServicio().getClubesServicios().size());
//		}
//	}
//	
//	@Test
////	@Transactional
//	public void test4() throws Exception {
////		List<Cliente> lista = clientes.getAll();
//		List<Servicio> lista = servicioDao.BuscarServicio();
//		for ( Servicio servicio : lista )
//		{
//			System.err.println(servicio);
//		}
//	}
	
	
//	@Test
////	@Transactional
//	public void test5() throws Exception {
////		List<Cliente> lista = clientes.getAll();
//		List<Suscription> lista = suscriptionDao.getAll();
//		for ( Suscription servicio : lista )
//		{
//			System.err.print(servicio);
//		}
//	}
//	@Test
////	@Transactional
//	public void test2() throws Exception {
////		List<Cliente> lista = clientes.getAll();
//		List<User> lista = usuario.getAll();
//		for ( User clienteA : lista )
//		{
//			
//			System.out.println(clienteA.getLogin());
//		}
//	}
	
//	@Test
//	public void supscripcionesAlta() throws Exception {
//		List<Suscription> lista = suscriptionDao.getAll();
//		for ( Suscription suscriptor : lista )
//		{
//			if(suscriptor.getServicio().getClubesServicios().size() >= 1)
//			System.err.println("Cliente: "+suscriptor.getCliente().getMsIsdn()+" "
//					         + "Operador: "+suscriptor.getCliente().getOperadore().getNombre()+
//					         " Fecha de Supscripcion: "+suscriptor.getSusTs()+
//					         " Servicio de Alta: "+suscriptor.getServicio().getPalabraCorta()
//					         +" al "+suscriptor.getServicio().getShortcode()+" Club: "+suscriptor.getServicio().getClubesServicios().get(0).getClube().getClubName()
//					         );
//		}
//	}
//	
//	
//	@Test
//	public void MensajesEnviados() throws Exception {
//		List<Suscription> lista = suscriptionDao.getAll();
//		for ( Suscription suscriptor : lista )
//		{
//			if(suscriptor.getServicio().getClubesServicios().size() >= 1)
//			System.err.println("Cliente: "+suscriptor.getCliente().getMsIsdn()+" "
//					         + "Operador: "+suscriptor.getCliente().getOperadore().getNombre()+
//					         " Fecha de Supscripcion: "+suscriptor.getSusTs()+
//					         " Servicio de Alta: "+suscriptor.getServicio().getPalabraCorta()
//					         +" al "+suscriptor.getServicio().getShortcode()+" Club: "+suscriptor.getServicio().getClubesServicios().get(0).getClube().getClubName()
//					         );
//		}
//	}
//	
//	
//	@Test
//	public void ReporteCobro() throws Exception {
//		List<Cobro> lista = cobroDao.getAll();
//		for ( Cobro cobro : lista )
//		{
//			if(cobro.getServicio().getClubesServicios().size() >= 1)
//			System.err.println("Cliente: "+cobro.getCliente().getMsIsdn()+" "
//					         + "Operador: "+cobro.getCliente().getOperadore().getNombre()+
//					         " Fecha de Cobro: "+cobro.getFechaCobro()+
//					         " Servicio de Alta: "+cobro.getServicio().getPalabraCorta()
//					         +" al "+cobro.getServicio().getShortcode()+
//					         " Club: "+cobro.getServicio().getClubesServicios().get(0).getClube().getClubName()
//					         +" Estado del Cobro: "+ cobro.getSmscStatusCode()
//					         );
//		}
//	}
	
	
//	@Test
//	public void ReporteCobro() throws Exception {
//		List<ClubesServicio> lista = clubServicio.getAll();
//		for ( ClubesServicio club : lista )
//		{
//
//			
//			System.err.println(club.getClube().getClubName()+ "   "+ club.getServicio().getShortcode());
//		}
//	}
	
	
//	
//	@Transactional
//	public List<Cliente> getClientes() throws Exception {
//		return clientes.getAll();
//	}


}
