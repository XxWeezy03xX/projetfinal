package org.formation.model;

public class Motif {
	
	private Enum<EMotif> motif;
	private Integer prix;
	
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
