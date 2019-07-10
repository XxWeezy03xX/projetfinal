package org.formation.restController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.formation.model.Adresse;
import org.formation.model.view.JsonViews;
import org.formation.repository.AdresseRepository;
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
@RequestMapping("/rest/adresse")
@CrossOrigin(origins="*")
public class AdresseRestController {
	
	@Autowired
	private AdresseRepository adresseRepository;
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(value= {"", "/"})
	public ResponseEntity<List<Adresse>> findAll(){
		return list();
	}
	
    @JsonView(JsonViews.Common.class)
@GetMapping(value = { "/user" })
private ResponseEntity<List<Adresse>> findAllWithUser() {
	return list();
}
    private ResponseEntity<List<Adresse>> list(){
		return new ResponseEntity<List<Adresse>>(adresseRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping(value= {"", "/"})
	public ResponseEntity<Void>create(@Valid @RequestBody Adresse adresse, BindingResult br, UriComponentsBuilder uCB){
		if (br.hasErrors()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		adresseRepository.save(adresse);
		HttpHeaders headers = new HttpHeaders();
		//URI uri = uCB.path("/rest/adresse/{numero}").buildAndExpand(adresse.getNumero()).toUri(); // permet de construite une uri a partir d'un chemin
		URI uri = uCB.path("/rest/adresse/{id}").buildAndExpand(adresse.getId()).toUri();																				
		headers.setLocation(uri);
		return new ResponseEntity<>(headers, HttpStatus.CREATED);
	}
	

    @JsonView(JsonViews.Common.class)
	@GetMapping("/{id}")
	public ResponseEntity<Adresse> findAllWithId(@PathVariable(name = "id") Integer id) {
		return findAdresseById(id);
	}
 
    @JsonView(JsonViews.Common.class)
    @GetMapping("/{id}/user")
    public ResponseEntity<Adresse> findByIdWithUser(@PathVariable(name="id") Integer id) {
        return findAdresseById(id);
    }


	private ResponseEntity<Adresse> findAdresseById(Integer id) {
		Optional<Adresse> opt = adresseRepository.findById(id);
		if (opt.isPresent()) {
			return new ResponseEntity<>(opt.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PutMapping("/{id}") // mise à jours du web service
	public ResponseEntity<Void> Update(@PathVariable(name = "id") Integer id, @RequestBody Adresse adresse) {
		Optional<Adresse> opt = adresseRepository.findById(id);
		if (opt.isPresent()) {
			Adresse adresseEnBase = opt.get();
			adresseEnBase.setNumero((adresse.getNumero() != null) ? adresse.getNumero() : adresseEnBase.getNumero());
			adresseEnBase.setRue((adresse.getRue() != null) ? adresse.getRue() : adresseEnBase.getRue());
			adresseEnBase.setCp((adresse.getCp() != null) ? adresse.getCp() : adresseEnBase.getCp());
			adresseEnBase.setVille((adresse.getVille() != null) ? adresse.getVille() : adresseEnBase.getVille());
			adresseRepository.save(adresseEnBase);
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void>delete(@PathVariable(name="id")Integer id){
		Optional<Adresse> opt=adresseRepository.findById(id);
		if(opt.isPresent()) {
			adresseRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	

}
