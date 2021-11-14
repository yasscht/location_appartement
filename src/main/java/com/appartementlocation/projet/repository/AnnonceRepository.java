package com.appartementlocation.projet.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.appartementlocation.projet.enumeration.PublicCible;
import com.appartementlocation.projet.models.Annonce;


@Repository
public interface AnnonceRepository extends JpaRepository<Annonce,Long> {
	Annonce findByTitle(String title);
	@Query(value = "SELECT * from annonces a where a.user_id =:id ", nativeQuery = true)    

	List<Annonce> findByUser(String id);

	List<Annonce> findByPublicCible( PublicCible gender);
	

	
    
	List<Annonce> findByPrixMoisLessThanEqual(float  prix);
	@Query(value = "SELECT * from annonces a where a.prix_mois between :min and :max ", nativeQuery = true)    
	List<Annonce> findByPrixMoisBetween(int min , int max);
	@Query(value = "SELECT * from annonces a where a.date_disponibilite between :date_debut and :date_fin ", nativeQuery = true) 
    List<Annonce> findByDateDisponibilite(Date date_debut,Date date_fin);
	
	List<Annonce> findByNombrePersonnesGreaterThanEqual(int nbr);
	
	

}
