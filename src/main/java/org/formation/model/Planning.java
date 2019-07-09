package org.formation.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class Planning {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id; 
	@OneToOne(mappedBy = "planning")
	private Praticien praticien;
//	@DateTimeFormat(pattern = "yyyy/MM/dd-HH:mm")
//	@Temporal(TemporalType.DATE)
//	private ArrayList<Date> dispo = new ArrayList<Date>();

	
	@OneToMany(mappedBy = "date")
	private List<Rdv> rdv; 
	
	public Planning() {
	}
	
	
	
	public Planning(Praticien praticien, ArrayList<Date> dispo) {
		this.praticien = praticien;
		this.dispo = dispo;
	}



	public Praticien getPraticien() {
		return praticien;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	

	public ArrayList<Date> getDispo() {
		return dispo;
	}

	public void setDispo(ArrayList<Date> dispo) {
		this.dispo = dispo;
	}

	public List<Rdv> getRdv() {
		return rdv;
	}

	public void setRdv(List<Rdv> rdv) {
		this.rdv = rdv;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dispo == null) ? 0 : dispo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((praticien == null) ? 0 : praticien.hashCode());
		result = prime * result + ((rdv == null) ? 0 : rdv.hashCode());
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
		if (dispo == null) {
			if (other.dispo != null)
				return false;
		} else if (!dispo.equals(other.dispo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (praticien == null) {
			if (other.praticien != null)
				return false;
		} else if (!praticien.equals(other.praticien))
			return false;
		if (rdv == null) {
			if (other.rdv != null)
				return false;
		} else if (!rdv.equals(other.rdv))
			return false;
		return true;
	}

	
}
