package org.formation.repository;

import java.util.List;

import org.formation.model.Adresse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AdresseRepository extends JpaRepository<Adresse, Integer> {

	@Query("select a from Adresse a")
	public List<Adresse> findAllCustom();
	
	
		
}
