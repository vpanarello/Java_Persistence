/**
 * 20160515-JPA_Exercice01 / Clientes.java
 * FIAP / RM30222 - Vagner Panarello
 */

package entity;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
@Table(name="clientes")
public class Clientes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="IDCLIENTE")
	private int idCliete;
	
	@Column(name = "NOME", length = 45)
	private String nome;
	
	@Column(name = "EMAIL", length = 45)
	private String email;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "cliente")
	private Set<Pedidos> pedidos = new HashSet<>();
	
	////////////////* Class Constructors *////////////////
		
	public Clientes(int idCliete, String nome, String email) {
		super();
		this.idCliete = idCliete;
		this.nome = nome;
		this.email = email;
	}
	public Clientes() {
		super();
	}

	////////////////* Getter & Setters *////////////////

	public int getIdCliete() {
		return idCliete;
	}

	public void setIdCliete(int idCliete) {
		this.idCliete = idCliete;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Pedidos> getPedidos() {
		return pedidos;
	}

	public void setPedido(Pedidos pedido) {
		this.pedidos.add(pedido);
	}
}
