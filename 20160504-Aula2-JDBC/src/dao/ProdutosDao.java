package dao;

import java.sql.SQLException;
import java.util.ArrayList;

import entity.Pedido;
import entity.Produto;

public class ProdutosDao extends DataAccessObject{

	@Override
	public void store(Object obj) throws Exception {
		
		if(obj instanceof Produto){
			Produto produto = (Produto) obj;
			try {
				this.openConnection();
				ps = cn.prepareStatement("INSERT INTO produtos (NOME,DESCRICAO,PRECO) VALUES (?,?,?)");
				
				ps.setString(1, produto.getNome());
				ps.setString(2, produto.getDescricao());
				ps.setFloat(3,produto.getPreco());
				ps.executeUpdate();
			} catch (Exception e) {
				throw e;
			} finally {
				this.closeConnection();
			}				
		} else {
			throw new Exception("Valid only instaces of 'Produtos' as arguments");
		}
	}

	@Override
	public Object recover(int id) throws Exception {
		
		Produto p = null;
		
		this.openConnection();
		ps = cn.prepareStatement("SELECT * FROM produtos WHERE ID=?");
		ps.setInt(1, id);
		rs = ps.executeQuery();
		
		if(rs.next()){
			p = new Produto(rs.getInt("ID"), rs.getString("NOME"), rs.getString("DESCRICAO"), rs.getFloat("PRECO"));
		}
		return p;
	}

	@Override
	public ArrayList<Object> listContent() throws Exception {
		
		ArrayList<Object> produto = new ArrayList<>();
		
		try {
			this.openConnection();	
			ps = cn.prepareStatement("SELECT * FROM produtos");
			ps.executeQuery();
			rs = ps.getResultSet();
			
			while(rs.next()) {
				Produto p = new  Produto(rs.getInt("ID"), rs.getString("NOME"), rs.getString("DESCRICAO"), rs.getFloat("PRECO"));
				produto.add(p);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw e;
		} finally {
			this.closeConnection();
			}
		return produto;
	}
	
	

}
