package org.formation.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

@Entity
public class Praticien extends User {
	
	@Enumerated(EnumType.ORDINAL)
	private Roles role;
	private Adresse lieux[];
	private EMotif motif;
	private String specialites[];
	private String presentation; 
	private String moyen_paiement;
	private String avis;
	private Integer note;
	@OneToMany
	@Enumerated(EnumType.STRING)
	private EMotif motifs[];
	
	
	public Praticien() {
		super();
	}
	
	public Roles getRole() {
		return role;
	}
	public void setRole(Roles role) {
		this.role = role;
	}
	public Adresse[] getLieux() {
		return lieux;
	}
	public void setLieux(Adresse[] lieux) {
		this.lieux = lieux;
	}
	public EMotif getMotif() {
		return motif;
	}
	public void setMotif(EMotif motif) {
		this.motif = motif;
	}
	public String[] getSpecialites() {
		return specialites;
	}
	public void setSpecialites(String[] specialites) {
		this.specialites = specialites;
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
	public EMotif[] getMotifs() {
		return motifs;
	}
	public void setMotifs(EMotif[] motifs) {
		this.motifs = motifs;
	}
	
	

}
