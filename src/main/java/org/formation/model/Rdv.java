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
import javax.persistence.SequenceGenerator;
import javax.persistence.Transient;

import org.formation.model.view.JsonViews;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;

@SequenceGenerator(name="seq", initialValue=1)
@Entity
public class Rdv {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq")
	@JsonView(JsonViews.Common.class)
	private Integer id;
	 @ManyToOne
	@JoinColumn(name="rdv_patient")
	private Patient patient;
	@ManyToOne
	@JoinColumn(name = "rdv_praticien")
	private Praticien praticien;
	//@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	//@JoinColumn(name = "rdv_planning")
//	private Planning date;
	@ManyToOne
	@JoinColumn(name = "rdv_motif")
	private Motif motif;
	@ManyToOne
	@JoinColumn(name = "rdv_lieu")
	@JsonView(JsonViews.Common.class)
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}
