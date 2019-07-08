package org.formation.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import org.springframework.data.annotation.Id;

@Entity
public class Rdv {
	@Id
	private Integer id;
	@OneToMany
	private Patient patients;
	@OneToMany
	private Praticien praticien;
	@OneToMany
	private Planning date;
	private String motif;
	private String lieu;
	
	public Rdv() {	
	}
	

	public Rdv(Integer id, Patient patients, Praticien praticien, Planning date, String motif, String lieu) {
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

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public String getLieu() {
		return lieu;
	}

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}


	@Override
	public String toString() {
		return "Rdv [id=" + id + ", patients=" + patients + ", praticien=" + praticien + ", date=" + date + ", motif="
				+ motif + ", lieu=" + lieu + "]";
	}
	



}
