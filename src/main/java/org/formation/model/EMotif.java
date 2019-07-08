package org.formation.model;

public enum EMotif {

	PREMIER_CONSULTATION("premiere consultation", 35), 
	SOIN_DENTAIRE("Soins des dents", 75);
	
	private String motif;
	private Integer prix;
	
	private EMotif(String motif, Integer prix) {
		this.motif = motif;
		this.prix = prix;
	} 
	
}
