//package org.formation.restController;
//
//import java.net.URI;
//import java.util.List;
//import java.util.Optional;
//
//import javax.validation.Valid;
//
//import org.formation.model.Planning;
//import org.formation.model.Rdv;
//import org.formation.model.view.JsonViews;
//import org.formation.repository.PlanningRepository;
//import org.formation.repository.RdvRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.util.UriComponentsBuilder;
//
//import com.fasterxml.jackson.annotation.JsonView;
//
//@RestController
//@RequestMapping("/rest/planning")
//@CrossOrigin(origins = "*")
//public class PlanningRestController {
//	
//	@Autowired
//	private PlanningRepository planningRepository;
//	
//	@JsonView(JsonViews.Common.class)
//	@GetMapping(value = {"", "/"})
//	public ResponseEntity<List<Planning>> findAll() {
//		return list();
//	}
//	
////	@JsonView(JsonViews.SoldatAvecArme.class)
////	@GetMapping(value = {"arme"})
////	private ResponseEntity<List<Rdv>> findAllWithArme(){
////		return new ResponseEntity<List<Soldat>>(soldatRepository.findAll(), HttpStatus.OK);
////	}
//	
//	private ResponseEntity<List<Planning>> list() {
//		return new ResponseEntity<List<Planning>>(planningRepository.findAll(), HttpStatus.OK);
//	}
//	
//	@PostMapping(value= {"", "/"})
//	public ResponseEntity<Void> create(@Valid @RequestBody Planning planning, BindingResult br, UriComponentsBuilder ucb) {
//		if(br.hasErrors()) {
//			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//		}
//		planningRepository.save(planning);
//		HttpHeaders headers = new HttpHeaders();
//		URI uri = ucb.path("/rest/planning/{id}").buildAndExpand(planning.getId()).toUri();
//		headers.setLocation(uri);
//		return new ResponseEntity<> (headers, HttpStatus.CREATED);
//	}
//	
//	@GetMapping("/{id}")
//	@JsonView(JsonViews.Common.class)
//	public ResponseEntity<Planning> findById(@PathVariable(name="id") Integer id) {
//		return findById(id);
//	}
//	
////	@GetMapping("/{id}/rdv")
////	@JsonView(JsonViews.Common.class)
////	public ResponseEntity<Planning> findByArme(@PathVariable(name="id") Integer id) {
////		return findById(id);
////	}
////	
////	@JsonView(JsonViews.Common.class)
////	public ResponseEntity<Planning> findSoldatById(Integer id) {
////		Optional<Rdv> opt =rdvRepository.findById(id);
////		if(opt.isPresent()) {
////			return new ResponseEntity<Rdv>(opt.get(), HttpStatus.OK);
////		}
////		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////	}
//	
//	@PutMapping("/{id}")
//	public ResponseEntity<Void> update(@PathVariable(name="id") Integer id, @Valid @RequestBody Planning planning, BindingResult br) {
//		Optional<Planning> opt = planningRepository.findById(id);
//		if (opt.isPresent()) {
//			Planning planningEnBase = opt.get();
//			planningEnBase.setDispo((planning.getDispo() != null) ? planning.getDispo():planningEnBase.getDispo());
//			planningEnBase.setPraticien((planning.getPraticien() != null) ? planning.getPraticien():planningEnBase.getPraticien());
//			planningRepository.save(planningEnBase);
//			return new ResponseEntity<>(HttpStatus.OK);
//		}
//		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
//	}
//	
//	@DeleteMapping("/{id}")
//	public ResponseEntity<Void> delete(@PathVariable(name="id") Integer id) {
//		Optional<Planning> opt = planningRepository.findById(id);
//		if(opt.isPresent()) {
//			planningRepository.deleteById(id);
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//	}
//}
