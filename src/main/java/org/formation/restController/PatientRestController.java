package org.formation.restController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.formation.model.Patient;
import org.formation.model.view.JsonViews;
import org.formation.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/rest/patient")
@CrossOrigin(origins="*")
public class PatientRestController {
	
	@Autowired
	private PatientRepository patientRepository;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(value= {"", "/"})
	public ResponseEntity<List<Patient>> findAll(){
		return list();
	}
	
        @JsonView(JsonViews.UserWithRdv.class)
	@GetMapping(value = { "/rdv" })
	private ResponseEntity<List<Patient>> findAllWithRdv() {
		return list();
	}
	
	private ResponseEntity<List<Patient>> list(){
		return new ResponseEntity<List<Patient>>(patientRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping(value= {"", "/"})
	public ResponseEntity<Void>create(@Valid @RequestBody Patient patient, BindingResult br, UriComponentsBuilder uCB){
		if (br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		patientRepository.save(patient);
		HttpHeaders headers = new HttpHeaders();
		URI uri = uCB.path("/rest/patient/{id}").buildAndExpand(patient.getId()).toUri(); // permet de construire une uri
																						// à partir d'un chemin
		headers.setLocation(uri);
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	

    @JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public ResponseEntity<Patient> findById(@PathVariable(name = "id") Integer id) {
		return findPatientById(id);
	}
 
    @JsonView(JsonViews.Common.class)
    @GetMapping("/{id}/rdv")
    public ResponseEntity<Patient> findByIdWithRdv(@PathVariable(name="id") Integer id) {
        return findPatientById(id);
    }



	private ResponseEntity<Patient> findPatientById(Integer id) {
		Optional<Patient> opt = patientRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<>(opt.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}") // mise à jours du web service
	public ResponseEntity<Void> Update(@PathVariable(name = "id") Integer id, @RequestBody Patient patient) {
		Optional<Patient> opt = patientRepository.findById(id);
		if (opt.isPresent()) {
			Patient patientEnBase = opt.get();
			patientEnBase.setPrenom((patient.getPrenom() != null) ? patient.getPrenom() : patientEnBase.getPrenom());
			patientEnBase.setNom((patient.getNom() != null) ? patient.getNom() : patientEnBase.getNom());
			patientEnBase.setEmail((patient.getEmail() != null) ? patient.getEmail() : patientEnBase.getEmail());
			patientEnBase.setNaissance((patient.getNaissance()!= null) ? patient.getNaissance() : patientEnBase.getNaissance());	
			patientEnBase.setSecu((patient.getSecu()!= null) ? patient.getSecu() : patientEnBase.getSecu());
			patientEnBase.setAdresse((patient.getAdresse() != null) ? patient.getAdresse() : patientEnBase.getAdresse());
			patientEnBase.setRole((patient.getRole() != null) ? patient.getRole() : patientEnBase.getRole());
			patientRepository.save(patientEnBase);
			return new ResponseEntity<>(HttpStatus.OK);
			
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>delete(@PathVariable(name="id")Integer id){
		Optional<Patient> opt=patientRepository.findById(id);
		if(opt.isPresent()) {
			patientRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

}
