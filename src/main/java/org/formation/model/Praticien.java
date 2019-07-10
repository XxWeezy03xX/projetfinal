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
//	@OneToMany(mappedBy = "praticien")
//	@Enumerated(EnumType.ORDINAL)
	@OneToOne
	@JoinColumn(name="praticien_motif")
	//private List<Motif> motifs = new ArrayList<Motif>();
	private Motif motif;
//	@OneToOne
//	@JoinColumn(name = "praticien_planning")
//	private Planning planning; 
	//@OneToMany(mappedBy = "praticien")
	@OneToOne
	@JoinColumn(name="praticien_rdv")
	//private List<Rdv> rdvs = new ArrayList<Rdv>(); 
	private Rdv rdv;
	
	
	public Praticien() {
		super();
	}


//	public Planning getPlanning() {
//		return planning;
//	}
//
//	public void setPlanning(Planning planning) {
//		this.planning = planning;
//	}

	
//	public List<Rdv> getRdvs() {
//		return rdvs;
//	}
//
//
//	public void setRdvs(List<Rdv> rdvs) {
//		this.rdvs = rdvs;
//	}


	public String getPresentation() {
		return presentation;
	}

	public Rdv getRdv() {
		return rdv;
	}


	public void setRdv(Rdv rdv) {
		this.rdv = rdv;
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


	public Motif getMotif() {
		return motif;
	}


	public void setMotif(Motif motif) {
		this.motif = motif;
	}

//
//	public List<Motif> getMotifs() {
//		return motifs;
//	}
//
//
//	public void setMotifs(List<Motif> motifs) {
//		this.motifs = motifs;
//	}

	

}
