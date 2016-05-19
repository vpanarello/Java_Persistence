package br.com.fiap.dao;

import static org.junit.Assert.*;

import org.junit.Test;

public class testDao {
	
	DaoInterface conexao;

	@Test
	public void test() throws Exception {
		
		
		conexao = new DaoInterface();
		
		
		conexao.abrirConexao();
		
		
	}

}
