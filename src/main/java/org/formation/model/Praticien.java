package org.formation.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
@DiscriminatorValue("praticien")
public class Praticien extends User {
	
	private String presentation; 
	private String moyen_paiement;
	private String avis;
	private Integer note;
	@OneToMany(mappedBy = "praticien")
	@Enumerated(EnumType.ORDINAL)
	private Set<Motif> motifs;
	@OneToOne
	@JoinColumn(name = "praticien_planning")
	private Planning planning; 
	@OneToMany(mappedBy = "praticien")
	private List<Rdv> rdv; 
	
	
	public Praticien() {
		super();
	}


	public Planning getPlanning() {
		return planning;
	}

	public void setPlanning(Planning planning) {
		this.planning = planning;
	}

	public List<Rdv> getRdv() {
		return rdv;
	}

	

	public void setRdv(List<Rdv> rdv) {
		this.rdv = rdv;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}
	public String getMoyen_paiement() {
		return moyen_paiement;
	}
	public void setMoyen_paiement(String moyen_paiement) {
		this.moyen_paiement = moyen_paiement;
	}
	public String getAvis() {
		return avis;
	}
	public void setAvis(String avis) {
		this.avis = avis;
	}
	public Integer getNote() {
		return note;
	}
	public void setNote(Integer note) {
		this.note = note;
	}

	public Set<Motif> getMotifs() {
		return motifs;
	}

	public void setMotifs(Set<Motif> motifs) {
		this.motifs = motifs;
	}		

}
