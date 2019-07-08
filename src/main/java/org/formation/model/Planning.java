package org.formation.model;

import java.util.ArrayList;
import java.util.List;

public class Planning {
	
	private Praticien praticien;
	private ArrayList disponibilite;
	
	
public Planning() {
}


public Praticien getPraticien() {
	return praticien;
}


public void setPraticien(Praticien praticien) {
	this.praticien = praticien;
}


public ArrayList getDisponibilite() {
	return disponibilite;
}


public void setDisponibilite(ArrayList disponibilite) {
	this.disponibilite = disponibilite;
}


public Planning(Praticien praticien, ArrayList disponibilite) {
	super();
	this.praticien = praticien;
	this.disponibilite = disponibilite;
}


@Override
public String toString() {
	return "Planning [praticien=" + praticien + ", disponibilite=" + disponibilite + "]";
}




}
