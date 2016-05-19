package br.com.fiap.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.java.Pedidos;

public class PedidosDao extends Dao {
	
	
	public void incluirPedido(Pedidos pedido) throws Exception {
		
		try {
			super.abrirConexao();
			String sql = "INSERT INTO PEDIDOS (IDCLIENTE,DATA,DESCRIAO,VALOR) VALUES(?,?,?,?)";
			
			stmt = cn.prepareStatement(sql);
			stmt.setInt(1, pedido.getIdClientes());
			stmt.setDate(2, new java.sql.Date(pedido.getData().getTime()));
			stmt.setString(3, pedido.getDescricao());
			stmt.setDouble(4, pedido.getValor());
			stmt.executeUpdate();

		} catch (Exception e) {
			
			throw e;
		} finally {
			super.fecharConexao();
		}
			
	}
	
	public List<Pedidos> listarPedidos() throws Exception {
		List<Pedidos> pedidos = new ArrayList<Pedidos>();
		
		try {
			super.abrirConexao();
			
			stmt = cn.prepareStatement("SELECT * FROM PEDIDOS");
			rs = stmt.executeQuery();
			while(rs.next()){
				Pedidos p = new Pedidos();
				p.setId(rs.getInt("ID"));
				p.setIdClientes(rs.getInt("IDCLIENTE"));
				p.setDescricao(rs.getString("DESCRICAO"));
				p.setData(rs.getDate("DATA"));
				p.setValor(rs.getDouble("VALOR"));
				
				pedidos.add(p);
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			super.fecharConexao();
		}
		
		return pedidos;
	}
	
		
		
	}