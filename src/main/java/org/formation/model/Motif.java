package org.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.formation.model.view.JsonViews;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
@SequenceGenerator(name="seq", initialValue=1)
@Entity
public class Motif {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	@JsonView(JsonViews.Common.class)
	private Integer id;
	@JsonView(JsonViews.Common.class)
	private String motif;
	@JsonView(JsonViews.Common.class)
	private Integer prix;
	@ManyToOne
	@JoinColumn(name="motif_praticien")
	@JsonView(JsonViews.Common.class)
	private Praticien praticien;
	@OneToMany(mappedBy = "motif")
	private List<Rdv> listesRdv = new ArrayList<Rdv>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

	public List<Rdv> getListesRdv() {
		return listesRdv;
	}

	public void setListesRdv(List<Rdv> listesRdv) {
		this.listesRdv = listesRdv;
	}

	public Integer getPrix() {
		return prix;
	}

	public void setPrix(Integer prix) {
		this.prix = prix;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
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
		Motif other = (Motif) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
