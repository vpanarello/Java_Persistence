/**
 * 
 */
package app;

import javax.persistence.*;

import entity.*;

/**
 * 20160515-JPA_Exercice01 / daoHelper.java
 * FIAP / RM30222 - Vagner Panarello
 */
public class daoHelper {
	private EntityManager em;

	public daoHelper(EntityManager em) {
		super();
		this.em = em;
	}
	
	public boolean putIntoDB(Clientes cliente) throws Exception{
		boolean retValue = false;
		if(cliente instanceof Clientes){
			dbAccess(cliente);
			retValue = true;
		} else {
			throw new Exception("Not an instance of 'Cliente' class"); 
		}
		return retValue;
	}
	public boolean putIntoDB(Pedidos pedido, int idCliente) throws Exception{
		boolean retValue = false;
		
		if (pedido instanceof Pedidos) {
			Clientes cliente = em.find(Clientes.class, idCliente);
			pedido.setCliente(cliente);
			cliente.setPedido(pedido); // add pedido to Cliente's ArrayList
			dbAccess(cliente);
			this.dbAccess(cliente);
			retValue = true;
		} else {
			throw new Exception("Not an instance of 'Pedidos' class"); 
		}
		return retValue;
	}
	private void dbAccess(Object ob){
		em.getTransaction().begin();
		em.persist(ob);
		em.getTransaction().commit();
	}
	
	

}
