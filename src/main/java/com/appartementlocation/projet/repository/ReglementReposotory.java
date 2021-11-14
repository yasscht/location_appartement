package com.appartementlocation.projet.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.appartementlocation.projet.models.Reglement;


@Repository
public interface ReglementReposotory extends JpaRepository<Reglement,Long>{

}
