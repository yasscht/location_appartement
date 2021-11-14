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

import com.appartementlocation.projet.models.Facilite;
import com.appartementlocation.projet.services.impl.FaciliteServiceImpl;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api")
public class faciliteController {
	
	private final com.appartementlocation.projet.services.impl.FaciliteServiceImpl faciliteServiceImpl;

	public faciliteController(FaciliteServiceImpl faciliteServiceImpl) {
		super();
		this.faciliteServiceImpl = faciliteServiceImpl;
	}
	
	@PostMapping("/facilite/save")
	public ResponseEntity<Facilite> saveFacilite(@RequestBody Facilite facilite){
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/facilite/save").toUriString());
		return ResponseEntity.created(uri).body(faciliteServiceImpl.saveFacilite(facilite));
	}
	
	@GetMapping("/facilites")
	public ResponseEntity<List<Facilite>> getFacilites(){
		return ResponseEntity.ok().body(faciliteServiceImpl.getFacilites());
	}
	
	@GetMapping("/facilite/{id}")
	@ResponseBody
	public ResponseEntity<Facilite> getFacilite(@PathVariable Long id){
		return ResponseEntity.ok().body(faciliteServiceImpl.getFacilite(id));
	}
	
	@DeleteMapping("/facilite/delete/{id}")
	public String DeleteFacilite(@PathVariable Long id){
		faciliteServiceImpl.DeleteFacilite(id);
		return "facilite deleted succesfuly!";
	}
	
}
