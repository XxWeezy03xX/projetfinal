package org.formation.model;

import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@DiscriminatorValue("patient")
public class Patient {
	
	@Enumerated(EnumType.ORDINAL)
	private Roles role;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date naissance;
	
	private Integer secu;
	
	@OneToMany(mappedBy = "id")
	private List<Rdv> listesRdv;
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((naissance == null) ? 0 : naissance.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		if (role != other.role)
			return false;
		if (secu == null) {
			if (other.secu != null)
				return false;
		} else if (!secu.equals(other.secu))
			return false;
		return true;
	}

	public Roles getRole() {
		return role;
	}

	public void setRole(Roles role) {
		this.role = role;
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
	
	

}
