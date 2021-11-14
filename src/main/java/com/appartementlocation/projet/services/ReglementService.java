package com.appartementlocation.projet.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appartementlocation.projet.models.Reglement;

@Service
public interface ReglementService {
	
	Reglement saveReglement(Reglement Reglement);
	List<Reglement> getReglements();
	Reglement getReglement(Long id);
	void DeleteReglement(Long id);
	
}
