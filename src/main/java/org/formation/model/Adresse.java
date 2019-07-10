package org.formation.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Integer numero;
	private String rue;
	private String cp;
	private String ville; 
	@ManyToOne
	@JoinColumn(name = "adresse_user")
	private User user; 
	@OneToOne(mappedBy = "lieu")
	private Rdv rdv;
	
	public Adresse() {}

	public User getUser() {
		return user;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Rdv getRdv() {
		return rdv;
	}


	public void setRdv(Rdv rdv) {
		this.rdv = rdv;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Integer getNumero() {
		return numero;
	}
	
	
	public Adresse(Integer numero, String rue, String cp, String ville) {
		super();
		this.numero = numero;
		this.rue = rue;
		this.cp = cp;
		this.ville = ville;
	}


	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCp() {
		return cp;
	}
	public void setCp(String cp) {
		this.cp = cp;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cp == null) ? 0 : cp.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((rdv == null) ? 0 : rdv.hashCode());
		result = prime * result + ((rue == null) ? 0 : rue.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
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
		Adresse other = (Adresse) obj;
		if (cp == null) {
			if (other.cp != null)
				return false;
		} else if (!cp.equals(other.cp))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (rdv == null) {
			if (other.rdv != null)
				return false;
		} else if (!rdv.equals(other.rdv))
			return false;
		if (rue == null) {
			if (other.rue != null)
				return false;
		} else if (!rue.equals(other.rue))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	}

	

}
