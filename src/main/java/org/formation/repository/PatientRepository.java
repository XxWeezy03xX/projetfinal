package org.formation.repository;

import java.util.List;
import java.util.Optional;

import org.formation.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PatientRepository extends JpaRepository<Patient, Integer> 
{
	@Query("select p from Patient p ")
	public List<Patient> findAllCustom();
	
	public List<Patient> findByPrenomContaining(String prenom);

}
