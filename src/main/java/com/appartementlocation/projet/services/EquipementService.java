package com.appartementlocation.projet.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appartementlocation.projet.models.Equipement;



@Service
public interface EquipementService {
	
	com.appartementlocation.projet.models.Equipement saveEquipement(com.appartementlocation.projet.models.Equipement equipement);
	com.appartementlocation.projet.models.Equipement getEquipement(Long id);
	List<Equipement> getEquipements();
	void DeleteEquipement(Long id);

}
