package daoTesting;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import dao.PedidosDao;
import dao.ProdutosDao;
import entity.Pedido;
import entity.Produto;

public class testDaoProduto {
	
	static Produto[] p;
	static ProdutosDao db_produto;
	
	@BeforeClass
	static public void inicialization() {
		db_produto = new ProdutosDao();
		
		p = new Produto[4];
		
		p[0] = new Produto(0, "TV Sony", "Televisão de LED de 46 polegadas", 2000);
		p[1] = new Produto(0, "SegaSaturn", "Videogame de 5.geração com 32bits", 1500);
		p[2] = new Produto(0, "Microndas", "Forno de 30L 1500w", 500);
		p[3] = new Produto(0, "HomeTheater", "Aparelho de Theather doméstico", 900);
	}
	
	@Test
	public void testStore(){
		try {
			for (Produto produto : p) {
				db_produto.store(produto);	
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	@Test
	public void testRecover(){
		Produto p01 = null;
		try {
			p01 = (Produto) db_produto.recover(2);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(p01);	
	}
	
	@Test
	public void testList(){
		
		ArrayList<Object> lista = null;
		try {
			lista = db_produto.listContent();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		for (Object produto : lista) {
			if(produto instanceof Produto) {
				System.out.println(produto);
			}
		}
	}
	
}
