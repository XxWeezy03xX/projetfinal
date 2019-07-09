package org.formation.model;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Motif {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private Enum<EMotif> motif;
	private Integer prix;
	@ManyToOne
	@JoinColumn(name = "motif_praticien")
	private Praticien praticien;
	@OneToOne
	@JoinColumn( name = " motif_rdv")
	private Rdv rdv;
	
	
	public Enum<EMotif> getMotif() {
		return motif;
	}
	public void setMotif(Enum<EMotif> motif) {
		this.motif = motif;
	}
	public Integer getPrix() {
		return prix;
	}
	public void setPrix(Integer prix) {
		this.prix = prix;
	} 
	
	
}
