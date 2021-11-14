package com.appartementlocation.projet.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.appartementlocation.projet.models.Reglement;
import com.appartementlocation.projet.services.impl.ReglementServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api")
public class ReglementController {
	
	private final ReglementServiceImpl reglementServiceImpl;

	public ReglementController(ReglementServiceImpl reglementServiceImpl) {
		super();
		this.reglementServiceImpl = reglementServiceImpl;
	}
	
	@PostMapping("/reglement/save")
	public ResponseEntity<Reglement> saveReglement(@RequestBody Reglement reglement) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/reglement/save").toUriString());
		return ResponseEntity.created(uri).body(reglementServiceImpl.saveReglement(reglement));
	}
	
	@GetMapping("/reglements")
	public ResponseEntity<List<Reglement>> getReglements(){
		return ResponseEntity.ok().body(reglementServiceImpl.getReglements());
	}
	
	@GetMapping("/reglement/{id}")
	@ResponseBody
	public ResponseEntity<Reglement> getReglement(@PathVariable Long id){
		return ResponseEntity.ok().body(reglementServiceImpl.getReglement(id));
	}
	
	@DeleteMapping("/reglement/delete/{id}")
	public String DeleteReglement(@PathVariable Long id) {
		reglementServiceImpl.DeleteReglement(id);
		return "Reglement deleted succesfuly!";
	}

}
