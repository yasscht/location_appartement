package com.appartementlocation.projet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appartementlocation.projet.models.Demand;

@Repository
public interface DemandRepository extends JpaRepository<Demand,Long>{
		
	List<Demand> findByAnnonce(Long id);

}
