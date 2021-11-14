package com.appartementlocation.projet.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.appartementlocation.projet.models.Reglement;
import com.appartementlocation.projet.repository.ReglementReposotory;



@Service
public class ReglementServiceImpl implements com.appartementlocation.projet.services.ReglementService {
	
	
	private final ReglementReposotory reglementReposotory;

	public ReglementServiceImpl(ReglementReposotory eeglementReposotory) {
		super();
		this.reglementReposotory = eeglementReposotory;
	}

	@Override
	public Reglement saveReglement(Reglement reglement) {
		// TODO Auto-generated method stub
		return reglementReposotory.save(reglement);
	}

	@Override
	public List<Reglement> getReglements() {
		// TODO Auto-generated method stub
		return reglementReposotory.findAll();
	}

	@Override
	public Reglement getReglement(Long id) {
		// TODO Auto-generated method stub
		return reglementReposotory.getById(id);
	}

	@Override
	public void DeleteReglement(Long id) {
		Reglement Reglement = getReglement(id);
		reglementReposotory.delete(Reglement);
	}

}
