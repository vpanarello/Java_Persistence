package entity;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name="filmes")
public class Filmes implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Column(name = "DURACAO")
	private double duracao;
	
	@Column(name = "NUMEROSALA")
	private int numeroSala;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDLOCAL")
	private Locais local;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getDuracao() {
		return duracao;
	}

	public void setDuracao(double duracao) {
		this.duracao = duracao;
	}

	public int getNumeroSala() {
		return numeroSala;
	}

	public void setNumeroSala(int numeroSala) {
		this.numeroSala = numeroSala;
	}

	@Override
	public String toString() {
		return "Filmes [id=" + id + ", duracao=" + duracao + ", numeroSala=" + numeroSala + "]";
	} 
	
}
