package org.formation.model;

import java.util.ArrayList;
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

import org.formation.model.view.JsonViews;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;


@Entity
@DiscriminatorValue("patient")
public class Patient extends User {
	
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date naissance;
	@JsonView(JsonViews.Common.class)
	private Integer secu;
	
	@OneToMany(mappedBy = "patient")
	@JsonView(JsonViews.Common.class)
	@JsonManagedReference
	private List<Rdv> listesRdv = new ArrayList<Rdv>();
	
	public Patient() {
	super();
	
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

	public List<Rdv> getListesRdv() {
		return listesRdv;
	}

	public void setListesRdv(List<Rdv> listesRdv) {
		this.listesRdv = listesRdv;
	}

}
