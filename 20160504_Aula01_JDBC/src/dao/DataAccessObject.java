



package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public abstract class DataAccessObject {

	protected Connection cn;
	protected PreparedStatement ps;
	protected ResultSet rs;

	public void openConnection() throws SQLException, ClassNotFoundException {

		Class.forName(AccessData.DRIVER.get());

		cn = DriverManager.getConnection( AccessData.URL.get(),
				AccessData.USERNAME.get(),
				AccessData.PASSCODE.get());
	}

	public void closeConnection() throws SQLException{
		if(this.cn != null && !this.cn.isClosed()){
			this.cn.close();
		}
	}
	
	
	public abstract int store(Object obj) throws Exception ; // implement return ID
	
	public abstract Object recover(int id) throws Exception ;
	
	public abstract Object remove(int id) throws Exception ;
	
	
	public abstract ArrayList<Object> listContent() throws Exception;
		
}
