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

import com.appartementlocation.projet.models.Equipement;
import com.appartementlocation.projet.services.impl.EquipementServiceImpl;



@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping(path = "/api")
public class EquipementConroller {
	
	private final EquipementServiceImpl equipementServiceImpl;

	public EquipementConroller(EquipementServiceImpl equipementServiceImpl) {
		super();
		this.equipementServiceImpl = equipementServiceImpl;
	}
	
	@PostMapping("/equipement/save")
	public ResponseEntity<Equipement> saveEquipement(@RequestBody Equipement equipement) {
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/equipement/save").toUriString());
		return ResponseEntity.created(uri).body(equipementServiceImpl.saveEquipement(equipement));
	}
	
	@GetMapping("/equipements")
	public ResponseEntity<List<Equipement>> getEquipements(){
		return ResponseEntity.ok().body(equipementServiceImpl.getEquipements());
	}
	
	@GetMapping("equipement/{id}")
	@ResponseBody
	public ResponseEntity<Equipement> getEquipement(@PathVariable Long id){
		return ResponseEntity.ok().body(equipementServiceImpl.getEquipement(id));
	} 
	
	@DeleteMapping("equipement/delete/{id}")
	public String DeleteEquipement(@PathVariable Long id) {
		equipementServiceImpl.DeleteEquipement(id);
		return "Equipement deleted succesfuly!";
	}
	
	
	
}
