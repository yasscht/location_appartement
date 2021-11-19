package com.appartementlocation.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appartementlocation.projet.models.Demand;

public interface DemandeRepository extends JpaRepository<Demand, Long>{

}
