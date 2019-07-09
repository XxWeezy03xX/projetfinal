package org.formation.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Planning {
	@OneToOne
	@JoinColumn(name= "praticien_id")
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
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((disponibilite == null) ? 0 : disponibilite.hashCode());
	result = prime * result + ((praticien == null) ? 0 : praticien.hashCode());
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
	Planning other = (Planning) obj;
	if (disponibilite == null) {
		if (other.disponibilite != null)
			return false;
	} else if (!disponibilite.equals(other.disponibilite))
		return false;
	if (praticien == null) {
		if (other.praticien != null)
			return false;
	} else if (!praticien.equals(other.praticien))
		return false;
	return true;
}
}
