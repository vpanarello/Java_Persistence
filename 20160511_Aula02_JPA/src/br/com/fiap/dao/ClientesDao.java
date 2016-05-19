package br.com.fiap.dao;

import java.util.List;
import java.util.ArrayList;

import br.com.fiap.java.Clientes;

public class ClientesDao extends Dao{
	
	/* métodos para incluir novo cliente */
	public void incluirCliente(Clientes cliente) throws Exception{
		
		try {
			super.abrirConexao();
			
			String sql = "INSERT INTO CLIENTES (NOME,EMAIL) VALUES (?,?)";
			stmt = cn.prepareStatement(sql);
			stmt.setString(1, cliente.getNome());
			stmt.setString(2, cliente.getEmail());
			stmt.executeUpdate();
			
		} catch (Exception e) {
			throw e;
		} finally {
			super.fecharConexao();
		}
	}
	
	/* métodos para buscar cliente em DB */
	public Clientes buscarCliente(int id) throws Exception{
		
		Clientes cliente = null;
		
		
		try {
			super.abrirConexao();
			stmt = cn.prepareStatement("SELECT * FROM CLIENTES WHERE ID=?");
			stmt.setInt(1, id);
			rs = stmt.executeQuery();
			
			if(rs.next()){
				cliente = new Clientes();
				cliente.setId(id);
				cliente.setNome(rs.getString("NOME"));
				cliente.setEmail(rs.getString("EMAIL"));
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			super.fecharConexao();
		}
		return cliente;
	}
	
	
	/* métodos para listar clientes */
	public List<Clientes> listarClientes()  {
		
		List<Clientes> clientes = new ArrayList<Clientes>();
		
		
		try {
			super.abrirConexao();
			
			stmt = cn.prepareStatement("SELECT * FROM CLIENTES");
			rs = stmt.executeQuery();
			while(rs.next()){
				Clientes c = new Clientes();
				c.setId(rs.getInt("ID"));
				c.setNome(rs.getString("NOME"));
				c.setEmail(rs.getString("EMAIL"));
				
				clientes.add(c);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return clientes;
	}
	
	

}
