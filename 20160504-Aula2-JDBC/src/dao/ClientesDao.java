package dao;
import java.sql.SQLException;
import java.util.ArrayList;
import entity.Cliente;

public class ClientesDao extends DataAccessObject {
	
	@Override
	public int store(Object obj) throws Exception {
		
		int lastID = -1;

		if(obj instanceof Cliente){
			Cliente cliente = (Cliente) obj;
			try {
				this.openConnection();
				ps = cn.prepareStatement("INSERT INTO CLIENTES (NOME,EMAIL) VALUES (?,?)");
				ps.setString(1, cliente.getNome());
				ps.setString(2, cliente.getEmail());
				ps.executeUpdate();
				
				rs = ps.executeQuery("SELECT LAST_INSERT_ID()");
				
				if(rs.next()){
					lastID = rs.getInt(1);
				}
				
			} catch (Exception e) {
				throw e;
			} finally {
				this.closeConnection();
			}				
		} else {
			throw new Exception("Valid only instaces of 'Clientes' as arguments");
		}
		return lastID;
	}

	@Override
	public Object recover(int id) throws Exception {
		
		Cliente c = null;
		
		try {
			this.openConnection();
			ps = cn.prepareStatement("SELECT * FROM CLIENTES WHERE ID=?");
			ps.setInt(1, id);

			rs = ps.executeQuery();
			
			if(rs.next()){
				c = new Cliente(id, rs.getString("NOME"), rs.getString("EMAIL"));
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.closeConnection();
		}
		return c;
	}

	@Override
	public ArrayList<Object> listContent() throws Exception {
		
		ArrayList<Object> clientes = new ArrayList<>();
				
		try {
			this.openConnection();	
			ps = cn.prepareStatement("SELECT * FROM CLIENTES");
			ps.executeQuery();
			rs = ps.getResultSet();
			
			while(rs.next()) {
				Cliente c = new Cliente(rs.getInt("ID"), rs.getString("NOME"), rs.getString("EMAIL"));
				clientes.add(c);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw e;
		} finally {
			this.closeConnection();
			}
		return clientes;
	}

	@Override
	public Object remove(int id) throws Exception {
		
		
		
		return null;
	}
	

	

}
