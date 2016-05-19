package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import entity.Pedido;

public class PedidosDao extends DataAccessObject {

	@Override
	public void store(Object obj) throws Exception {
		
		if (obj instanceof Pedido) {
			Pedido pedido = (Pedido) obj;
			
			this.openConnection();
			
			try {
				ps = cn.prepareStatement("INSERT INTO PEDIDO (IDCLIENTE,IDPRODUTO,QUANTIDADE) VALUES (?,?,?)");
				ps.setInt(1, pedido.getIdCliente());
				ps.setInt(2, pedido.getIdProduto());
				ps.setInt(3, pedido.getQuantidade());
				ps.executeUpdate();
			} catch (Exception e){
				throw e;
			} finally {
				this.closeConnection();
			}
		} else {
			throw new Exception("Valid only instaces of 'Pedidos' as arguments");
		}
	}

	@Override
	public Object recover(int id) throws Exception {
		
		Pedido p = null;
		
		this.openConnection();
		ps = cn.prepareStatement("SELECT * FROM pedido WHERE ID=?");
		ps.setInt(1, id);
		rs = ps.executeQuery();
		
		if(rs.next()){
			p = new Pedido(rs.getInt("ID"), rs.getInt("IDCLIENTE"), rs.getInt("IDPRODUTO"), rs.getInt("QUANTIDADE"));
		}
		
		return p;
	}

	@Override
	public ArrayList<Object> listContent() throws Exception {
		
		ArrayList<Object> pedidos = new ArrayList<>();
		
		try {
			this.openConnection();	
			ps = cn.prepareStatement("SELECT * FROM PEDIDO");
			ps.executeQuery();
			rs = ps.getResultSet();
			
			while(rs.next()) {
				Pedido p = new Pedido(rs.getInt("ID"), rs.getInt("IDCLIENTE"), rs.getInt("IDPRODUTO"), rs.getInt("QUANTIDADE")); 
				pedidos.add(p);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw e;
		} finally {
			this.closeConnection();
			}
		return pedidos;
	}
}
