package org.formation.repository;

import java.util.List;

import org.formation.model.Praticien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PraticienRepository extends JpaRepository<Praticien, Integer>
{
	public List<Praticien> findByNomContaining(String nom);
	
	@Query("select r from Praticien r ")
	public List<Praticien> findAllCustom();


}
