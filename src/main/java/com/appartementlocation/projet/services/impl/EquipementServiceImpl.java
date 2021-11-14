package com.appartementlocation.projet.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.appartementlocation.projet.models.Equipement;
import com.appartementlocation.projet.repository.EquipementRepository;
import com.appartementlocation.projet.services.EquipementService;



@Service

@Transactional 

public class EquipementServiceImpl implements EquipementService{
	
	private final EquipementRepository equipementRepository;
	

	public EquipementServiceImpl(EquipementRepository equipementRepository) {
		super();
		this.equipementRepository = equipementRepository;
	}

	@Override
	public Equipement saveEquipement(Equipement equipement) {
		// TODO Auto-generated method stub
		return equipementRepository.save(equipement);
	}

	@Override
	public Equipement getEquipement(Long id) {
		// TODO Auto-generated method stub
		return equipementRepository.getById(id);
	}

	@Override
	public List<Equipement> getEquipements() {
		// TODO Auto-generated method stub
		return equipementRepository.findAll();
	}

	@Override
	public void DeleteEquipement(Long id) {
		Equipement equipement = getEquipement(id);
		equipementRepository.delete(equipement);
	}
	
	

}
