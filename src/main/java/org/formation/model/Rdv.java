package org.formation.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


@Entity
public class Rdv {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@ManyToOne
	@JoinColumn(name="rdv_patient")
	private Patient patient;
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "rdv_praticien")
	private Praticien praticien;
//	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
//	@JoinColumn(name = "rdv_planning")
//	private Planning date;
	@OneToOne
	@JoinColumn(name = "rdv_motif")
	private Motif motif;
	@OneToOne
	@JoinColumn(name = "rdv_lieu")
	private Adresse lieu;
	
	public Rdv() {	
	}
	
	public Rdv(Integer id, Patient patient, Praticien praticien, Motif motif, Adresse lieu) {
		super();
		this.id = id;
		this.patient = patient;
		this.praticien = praticien;
//		this.date = date;
		this.motif = motif;
		this.lieu = lieu;
	}


//	public void setDate(Planning date) {
//		this.date = date;
//	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

//	public Planning getDate() {
//		return date;
//	}
//
//	public void setPlanning(Planning date2) {
//		this.date = date2;
//	}

	public Motif getMotif() {
		return motif;
	}

	public void setMotif(Motif motif) {
		this.motif = motif;
	}

	public Adresse getLieu() {
		return lieu;
	}

	public void setLieu(Adresse a) {
		this.lieu = a;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lieu == null) ? 0 : lieu.hashCode());
		result = prime * result + ((motif == null) ? 0 : motif.hashCode());
		result = prime * result + ((patient == null) ? 0 : patient.hashCode());
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
		Rdv other = (Rdv) obj;
//		if (date == null) {
//			if (other.date != null)
//				return false;
//		} else if (!date.equals(other.date))
//			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lieu == null) {
			if (other.lieu != null)
				return false;
		} else if (!lieu.equals(other.lieu))
			return false;
		if (motif == null) {
			if (other.motif != null)
				return false;
		} else if (!motif.equals(other.motif))
			return false;
		if (patient == null) {
			if (other.patient != null)
				return false;
		} else if (!patient.equals(other.patient))
			return false;
		if (praticien == null) {
			if (other.praticien != null)
				return false;
		} else if (!praticien.equals(other.praticien))
			return false;
		return true;
	}

	
}
