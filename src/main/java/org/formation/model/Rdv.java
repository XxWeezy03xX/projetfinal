package org.formation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.Id;

@Entity
public class Rdv {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@ManyToOne
	@JoinColumn(name= "join_patient_id")
	private Patient patients;
	@ManyToOne
	@JoinColumn(name= "join_praticien_id")
	private Praticien praticien;
	@ManyToOne
	@JoinColumn(name= "join_date_id")
	private Planning date;
	private Motif motif;
	private Adresse lieu;
	
	public Rdv() {	
	}
	
	public Rdv(Integer id, Patient patients, Praticien praticien, Planning date, Motif motif, Adresse lieu) {
		super();
		this.id = id;
		this.patients = patients;
		this.praticien = praticien;
		this.date = date;
		this.motif = motif;
		this.lieu = lieu;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Patient getPatients() {
		return patients;
	}

	public void setPatients(Patient patients) {
		this.patients = patients;
	}

	public Praticien getPraticien() {
		return praticien;
	}

	public void setPraticien(Praticien praticien) {
		this.praticien = praticien;
	}

	public Planning getDate() {
		return date;
	}

	public void setDate(Planning date) {
		this.date = date;
	}

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

}
