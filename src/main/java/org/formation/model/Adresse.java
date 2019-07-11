package org.formation.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.formation.model.view.JsonViews;

import com.fasterxml.jackson.annotation.JsonView;

@SequenceGenerator(name="seq", initialValue=1)
@Entity
public class Adresse {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	@JsonView(JsonViews.Common.class)
	private Integer id;
	@JsonView(JsonViews.Common.class)
	private Integer numero;
	@JsonView(JsonViews.Common.class)
	private String rue;
	@JsonView(JsonViews.Common.class)
	private String cp;
	@JsonView(JsonViews.Common.class)
	private String ville; 
	 @ManyToOne( cascade = CascadeType.ALL)
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


}
