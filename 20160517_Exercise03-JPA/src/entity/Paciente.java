/**
 * 
 */
package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * 20160518-Exercise03-JPA / Paciente.java
 * FIAP / RM30222 - Vagner Panarello
 */

@Entity
@Table(name="paciente")
public class Paciente implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "CPF")
	private String CPF;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "DATANASC")
	private Date dataNascimento;
	
	@Column(name = "TELEFONE")
	private String telefone;
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="pacientes")
	private Set<Agenda> agendas = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "paciente")
	private Set<Procedimento> procedimentos = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "paciente")
	private Set<Matmed>  matmeds = new HashSet<>();
	
	public Paciente() {
		super();
	}

	/**
	 * @param cPF
	 * @param nome
	 * @param dataNascimento
	 * @param telefone
	 * @param agendas
	 */
	public Paciente(String cPF, String nome, Date dataNascimento, String telefone) {
		super();
		CPF = cPF;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String cPF) {
		CPF = cPF;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public Set<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(Set<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	@Override
	public String toString() {
		return "Paciente [CPF=" + CPF + ", nome=" + nome + ", dataNascimento=" + dataNascimento + ", telefone="
				+ telefone + ", agendas=" + agendas + "]";
	}
}
