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
 * 20160518-Exercise03-JPA / agenda.java
 * FIAP / RM30222 - Vagner Panarello
 */

@Entity
@Table(name="agenda")
public class Agenda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ID")
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="DATA")
	private Date data;
	
	@Temporal(TemporalType.TIME)
	@Column(name="HORA")
	private Date hora;
	
	@Column(name="DESCRICAO")
	private String descricao;
	
	@ManyToMany(fetch=FetchType.LAZY, cascade= CascadeType.ALL)
	@JoinTable(name="agenda_paciente", catalog="ex03_jpa", joinColumns = {@JoinColumn(name="AGENDA_ID", nullable=false, updatable=false)},inverseJoinColumns = {@JoinColumn(name="PACIENTE_CPF", nullable=false,updatable=false)})
	private Set<Paciente> pacientes = new HashSet<>();
	

	public Agenda() {
		super();
	}

	/**
	 * @param data
	 * @param hora
	 * @param descricao
	 */
	public Agenda(Date data, Date hora, String descricao) {
		super();
		this.data = data;
		this.hora = hora;
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHora() {
		return hora;
	}

	public void setHora(Date hora) {
		this.hora = hora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Agenda [id=" + id + ", data=" + data + ", hora=" + hora + ", descricao=" + descricao + "]";
	} 
	
	

}
