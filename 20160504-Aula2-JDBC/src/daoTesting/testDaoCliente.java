package daoTesting;

import static org.junit.Assert.*;

import java.sql.SQLException;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.ClientesDao;
import entity.Cliente;

public class testDaoCliente {
	
	static Cliente c;
	static ClientesDao db_clientes;
	
	
	@BeforeClass
	static public void inicialization() {
		db_clientes = new ClientesDao();
		c  = new Cliente();
		c.setNome("Vagner Panarello");
		c.setEmail("vpanarello@gmail.com");
	}
	

	@Test
	public void testStoreClient(){
		try {
			db_clientes.store(c);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testRecoverClient(){
		Cliente c01 = null;
		try {
			c01 = (Cliente) db_clientes.recover(2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(c01);	
	}
	@Test
	public void testListClientes(){
		
		ArrayList<Object> lista = null;
		try {
			lista = db_clientes.listContent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (Object cliente : lista) {
			if(cliente instanceof Cliente) {
				System.out.println(cliente);
			}
			
		}
	}
	
}
