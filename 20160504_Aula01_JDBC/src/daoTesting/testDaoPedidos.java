package daoTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.ClientesDao;
import dao.PedidosDao;
import entity.Cliente;
import entity.Pedido;

public class testDaoPedidos {
	
	static Pedido p;
	static PedidosDao db_pedidos;
	
	
	@BeforeClass
	static public void inicialization() {
		db_pedidos = new PedidosDao();
		p  = new Pedido(0, 2, 2, 3);
	}
	
	@Test
	public void testStore(){
		try {
			db_pedidos.store(p);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testRecover(){
		p = null;
		try {
			p = (Pedido) db_pedidos.recover(1);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(p);
	}
	@Test
	public void testList(){
		
		ArrayList<Object> lista = null;
		try {
			lista = db_pedidos.listContent();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Object pedido : lista) {
			if(pedido instanceof Pedido) {
				System.out.println(pedido);
			}
		}
	}
}
