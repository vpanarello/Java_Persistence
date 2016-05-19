/**
 * 
 */
package entity;

import java.io.Serializable;
import java.sql.Date;
import java.time.format.DateTimeFormatter;

import javax.persistence.*;

/**
 * 20160515-JPA_Exercice01 / Pedidos.java
 * FIAP / RM30222 - Vagner Panarello
 */

@Entity
@Table(name="pedidos")
public class Pedidos implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "IDPEDIDO")
	private int idPedido;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCLIENTE")
	private Clientes cliente;
	
	@Column(name = "DATA")
	private Date data;
	
	@Column(name = "DESCRICAO", length = 45)
	private String descricao;
	
	@Column(name = "VALOR")
	private double valor;
	
	////////////////* Class Constructors *////////////////
	
	public Pedidos(int idPedido, Date data, String descricao, double valor) {
		super();
		this.idPedido = idPedido;
		this.data = data;
		this.descricao = descricao;
		this.valor = valor;
	}	
	public Pedidos() {
		super();
	}
	
	////////////////* Getter & Setters *////////////////

	public int getIdPedido() {
		return idPedido;
	}
	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public Clientes getCliente() {
		return cliente;
	}

	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
}
