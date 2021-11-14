package com.appartementlocation.projet.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.appartementlocation.projet.models.Demand;
import com.appartementlocation.projet.services.impl.DemandServiceImpl;

@RestController
@RequestMapping(path= "/api/demand")
public class DemandController {
	
	private final DemandServiceImpl demandServiceImpl;

	public DemandController(DemandServiceImpl demandServiceImpl) {
		super();
		this.demandServiceImpl = demandServiceImpl;
	} 
	
	@PostMapping("/save")
	public ResponseEntity<Demand> saveDemand(@RequestBody Demand demand ) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/demand/save").toUriString());
		return ResponseEntity.created(uri).body(demandServiceImpl.saveDemand(demand));
	}
	
	
	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<List<Demand>> getAllDemandForAnAnnonce(@PathVariable Long id){
		return ResponseEntity.ok().body(demandServiceImpl.getAllDemandForAnAnnonce(id));
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteDemand(@PathVariable Long id) {
		demandServiceImpl.DeleteDemand(id);
		return "Demande supprimer avec succee!";
	}
	
	@PostMapping("/update/{id}")
	public ResponseEntity<Demand> updateDemand(@RequestBody Demand demand,@PathVariable Long id ) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/demand/update/save").toUriString());
		return ResponseEntity.created(uri).body(demandServiceImpl.UpdateDemand(demand, id));
	}
	
	@GetMapping("/accept/{id}")
	@ResponseBody
	public String acceptDemand(@PathVariable Long id) {
		demandServiceImpl.AcceptDemand(id);
		return "Demande accepte avec succee!";
	}
	@GetMapping("/refus/{id}")
	@ResponseBody
	public String refusDemand(@PathVariable Long id) {
		demandServiceImpl.RefusDemand(id);
		return "Demande refuser!";
	}
	

}
