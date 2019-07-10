package org.formation.model;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@DiscriminatorValue("patient")
public class Patient extends User {
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date naissance;
	
	private Integer secu;
	
	//@OneToMany(mappedBy = "patient")
	@OneToOne(mappedBy = "patient")
	//private List<Rdv> listesRdv;
	private Rdv rdv;
	
	public Patient() {
	super();
	
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naissance == null) ? 0 : naissance.hashCode());
		result = prime * result + ((secu == null) ? 0 : secu.hashCode());
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
		Patient other = (Patient) obj;
		if (naissance == null) {
			if (other.naissance != null)
				return false;
		} else if (!naissance.equals(other.naissance))
			return false;
		if (secu == null) {
			if (other.secu != null)
				return false;
		} else if (!secu.equals(other.secu))
			return false;
		return true;
	}

	public Date getNaissance() {
		return naissance;
	}

	public void setNaissance(Date naissance) {
		this.naissance = naissance;
	}

	public Integer getSecu() {
		return secu;
	}

	public void setSecu(Integer secu) {
		this.secu = secu;
	}

	public Rdv getRdv() {
		return rdv;
	}

	public void setRdv(Rdv rdv) {
		this.rdv = rdv;
	}

//	public List<Rdv> getListesRdv() {
//		return listesRdv;
//	}
//
//	public void setListesRdv(List<Rdv> listesRdv) {
//		this.listesRdv = listesRdv;
//	}
	
	

}
