package org.formation.model;

import java.util.ArrayList;
import java.util.List;

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
	private List<Motif> motifs = new ArrayList<Motif>();
	private Integer prix;
	@ManyToOne
	@JoinColumn(name = "motif_praticien")
	private Praticien praticien;
	@OneToOne
	@JoinColumn( name = " motif_rdv")
	private Rdv rdv;
	
	
	public List<Motif> getMotifs() {
		return motifs;
	}


	public void setMotifs(List<Motif> motifs) {
		this.motifs = motifs;
	}
	public Integer getPrix() {
		return prix;
	}
	public void setPrix(Integer prix) {
		this.prix = prix;
	} 
	
	
}
