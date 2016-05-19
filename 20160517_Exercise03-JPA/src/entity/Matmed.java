/**
 * 
 */
package entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * 20160518-Exercise03-JPA / Matmed.java
 * FIAP / RM30222 - Vagner Panarello
 */

@Entity
@Table(name="matmed")
public class Matmed implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "DESCRICAO")
	private String descricao;
	
	@Column(name = "PRECO")
	private double preco;
	
	@Column(name = "FABRICANTE")
	private String fabricante;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CPFPAC")
	private Paciente paciente;

	public Matmed() {
		super();
	}

	/**
	 * @param descricao
	 * @param preco
	 * @param fabricante
	 * @param paciente
	 */
	public Matmed(String descricao, double preco, String fabricante, Paciente paciente) {
		super();
		this.descricao = descricao;
		this.preco = preco;
		this.fabricante = fabricante;
		this.paciente = paciente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getFabricante() {
		return fabricante;
	}

	public void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	@Override
	public String toString() {
		return "Matmed [id=" + id + ", descricao=" + descricao + ", preco=" + preco + ", fabricante=" + fabricante
				+ "]";
	}
}
