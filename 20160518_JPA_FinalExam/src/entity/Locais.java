package entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="locais")
public class Locais implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "LOCAL")
	private String local;
	
	@Column(name = "NUMSALAS")
	private int numSalas;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "IDCINEMA")
	private Cinemas cinema;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "local")
	private Set<Filmes> filme = new HashSet<>();


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public int getNumSalas() {
		return numSalas;
	}

	public void setNumSalas(int numSalas) {
		this.numSalas = numSalas;
	}

	@Override
	public String toString() {
		return "Locais [id=" + id + ", local=" + local + ", numSalas=" + numSalas + "]";
	}


}
