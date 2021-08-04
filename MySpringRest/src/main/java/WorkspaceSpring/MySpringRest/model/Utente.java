package WorkspaceSpring.MySpringRest.model;

import javax.persistence.*;

@Entity
@Table(name="Utenti")
public class Utente {
	@Id
	@GeneratedValue (strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column (nullable=false, length=30)
	private String nome;
	
	@Column (nullable=false, length=30)
	private String cognome;
	
	@Column (name="codice_fiscale", nullable=false, length=16, unique=true)
	private String codiceFisc;
	
	public Utente(){};
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getCodiceFisc() {
		return codiceFisc;
	}

	public void setCodiceFisc(String codiceFisc) {
		this.codiceFisc = codiceFisc;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codiceFisc == null) ? 0 : codiceFisc.hashCode());
		result = prime * result + ((cognome == null) ? 0 : cognome.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Utente other = (Utente) obj;
		if (codiceFisc == null) {
			if (other.codiceFisc != null)
				return false;
		} else if (!codiceFisc.equals(other.codiceFisc))
			return false;
		if (cognome == null) {
			if (other.cognome != null)
				return false;
		} else if (!cognome.equals(other.cognome))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return id+","+nome+","+cognome+","+codiceFisc;
	}
	
	
}
