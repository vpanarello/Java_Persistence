package entity;

import java.io.Serializable;

public class Pedido implements Serializable {
	
	private static final long serialVersionUID = 1L;
	int id;
	int idCliente;
	int idProduto;
	int quantidade;
	
	public Pedido() {
		super();
	}
	public Pedido(int id, int idCliente, int idProduto, int quantidade) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.idProduto = idProduto;
		this.quantidade = quantidade;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getIdCliente() {
		return idCliente;
	}
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public int getIdProduto() {
		return idProduto;
	}
	public void setIdProduto(int idProduto) {
		this.idProduto = idProduto;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", idCliente=" + idCliente + ", idProduto=" + idProduto + ", quantidade="
				+ quantidade + "]";
	}
}
