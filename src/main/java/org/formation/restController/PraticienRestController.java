package org.formation.restController;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.formation.model.Praticien;
import org.formation.model.view.JsonViews;
import org.formation.repository.PraticienRepository;
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
@RequestMapping("/rest/praticien")
@CrossOrigin(origins="*")
public class PraticienRestController 
{
	@Autowired
	private PraticienRepository praticienRepository;
	
	
	ResponseEntity<List<Praticien>> list()
	{
		return new ResponseEntity<List<Praticien>>(praticienRepository.findAll(), HttpStatus.OK);
		
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(value= {"","/"})
	public ResponseEntity<List<Praticien>> findAll()
	{
		return list();
	}
	
	@JsonView(JsonViews.Common.class)
	@GetMapping(value= {"/rdv"})
	public ResponseEntity<List<Praticien>> findAllWithRdv()
	{
		return list();
	}
	
	@PostMapping(value= {"","/"})
    public ResponseEntity<Void> create(@Valid @RequestBody Praticien praticien, BindingResult br, UriComponentsBuilder uCB) { //uricomponentsbuilder est un outil de spring permettant de créer des urls
        if(br.hasErrors()) {
            return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
        }
        praticienRepository.save(praticien);
        HttpHeaders headers = new HttpHeaders();
        URI uri = uCB.path("/rest/praticien/{id}").buildAndExpand(praticien.getId()).toUri(); // cette ligne permet de générer le chemin complet (url = adresse web avec http) avec l'id du soldat et de la transformer en uri (=adresse gobale)
        headers.setLocation(uri);
        return new ResponseEntity<Void> (headers,HttpStatus.CREATED);
    }
    
    @JsonView(JsonViews.Common.class)
    @GetMapping("/{id}") // c'est du get car on a une remontée d'info, car cette méthode consiste à remonter un objet (en l'occurence un soldat)
    public ResponseEntity<Praticien> findById(@PathVariable(name="id") Integer id) { //le pathvariable permet de récupérer une variable directement dans l'url et de l'injecter dans la valeur mis à coté (ici l'Integer id)
        return findPraticienById(id);
    }
    
    
    @JsonView(JsonViews.Common.class)
    @GetMapping("/{id}/arme")
    public ResponseEntity<Praticien> findByIdWithRdv(@PathVariable(name="id") Integer id) {
        return findPraticienById(id);
    }
    
     private ResponseEntity<Praticien> findPraticienById(@PathVariable(name="id") Integer id) {
        Optional<Praticien> opt = praticienRepository.findById(id);
        if (opt.isPresent()) {
            return new ResponseEntity<Praticien>(opt.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
     @PutMapping("/{id}")
     public ResponseEntity<Void> update(@PathVariable(name="id") Integer id, @RequestBody Praticien praticien, BindingResult br)
     {
    	 Optional<Praticien> opt = praticienRepository.findById(id);
    	 if(opt.isPresent())
    	{
    		 Praticien praticienEnBase = opt.get();
    		 praticienEnBase.setPrenom((praticien.getPrenom() != null)? praticien.getPrenom():praticienEnBase.getPrenom());
    		 praticienEnBase.setNom((praticien.getNom() != null)? praticien.getNom():praticienEnBase.getNom());
    		 praticienEnBase.setAdresse(((praticien.getAdresse() != null)? praticien.getAdresse():praticienEnBase.getAdresse()));
    		 praticienEnBase.setRdvs(praticien.getRdvs());
    		 praticienRepository.save(praticienEnBase);
    		 return new ResponseEntity<>(HttpStatus.OK);
    		 
    	}
    	return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);	 
     }
     
     @DeleteMapping("/{id}")
     public ResponseEntity<Void> delete(@PathVariable(name="id") Integer id)
     {
    	 Optional<Praticien> opt = praticienRepository.findById(id);
    	 if(opt.isPresent())
    	{
    		 praticienRepository.deleteById(id);
    		 return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    		 
    	}
    	return new ResponseEntity<>(HttpStatus.NOT_FOUND);	 
     }
}
