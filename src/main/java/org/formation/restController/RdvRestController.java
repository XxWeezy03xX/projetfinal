package org.formation.restController;

import java.net.URI;
import java.util.*;

import javax.validation.Valid;

import org.formation.model.Rdv;
import org.formation.model.view.JsonViews;
import org.formation.repository.RdvRepository;
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
@RequestMapping("/rest/rdv")
@CrossOrigin(origins = "*")
public class RdvRestController {
	
	@Autowired
	private RdvRepository rdvRepository;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(value = {"", "/"})
	public ResponseEntity<List<Rdv>> findAll() {
		return list();
	}
	
//	@JsonView(JsonViews.SoldatAvecArme.class)
//	@GetMapping(value = {"arme"})
//	private ResponseEntity<List<Rdv>> findAllWithArme(){
//		return new ResponseEntity<List<Soldat>>(soldatRepository.findAll(), HttpStatus.OK);
//	}
	
	private ResponseEntity<List<Rdv>> list() {
		return new ResponseEntity<List<Rdv>>(rdvRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping(value= {"", "/"})
	public ResponseEntity<Void> create(@Valid @RequestBody Rdv rdv, BindingResult br, UriComponentsBuilder ucb) {
		if(br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		rdvRepository.save(rdv);
		HttpHeaders headers = new HttpHeaders();
		URI uri = ucb.path("/rest/rdv/{id}").buildAndExpand(rdv.getId()).toUri();
		headers.setLocation(uri);
		return new ResponseEntity<> (headers, HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Rdv> findById(@PathVariable(name="id") Integer id) {
		return findById(id);
	}
	
	@GetMapping("/{id}/rdv")
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Rdv> findByArme(@PathVariable(name="id") Integer id) {
		return findById(id);
	}
	
	@JsonView(JsonViews.Common.class)
	public ResponseEntity<Rdv> findSoldatById(Integer id) {
		Optional<Rdv> opt =rdvRepository.findById(id);
		if(opt.isPresent()) {
			return new ResponseEntity<Rdv>(opt.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Void> update(@PathVariable(name="id") Integer id, @Valid @RequestBody Rdv rdv, BindingResult br) {
		Optional<Rdv> opt = rdvRepository.findById(id);
		if (opt.isPresent()) {
			Rdv rdvEnBase = opt.get();
			rdvEnBase.setPatient((rdv.getPatient() != null) ? rdv.getPatient():rdvEnBase.getPatient());
			rdvEnBase.setPraticien((rdv.getPraticien() != null) ? rdv.getPraticien():rdvEnBase.getPraticien());
			rdvEnBase.setDate((rdv.getDate() != null) ? rdv.getDate(): rdvEnBase.getDate());
			rdvEnBase.setMotif((rdv.getMotif() != null) ? rdv.getMotif(): rdvEnBase.getMotif());
			rdvEnBase.setLieu((rdv.getLieu() != null) ? rdv.getLieu(): rdvEnBase.getLieu());
			rdvRepository.save(rdvEnBase);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable(name="id") Integer id) {
		Optional<Rdv> opt = rdvRepository.findById(id);
		if(opt.isPresent()) {
			rdvRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
}
