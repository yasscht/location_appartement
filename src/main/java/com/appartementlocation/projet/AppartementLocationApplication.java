package com.appartementlocation.projet;

import java.io.File;
import java.sql.Date;
import java.util.ArrayList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.appartementlocation.projet.enumeration.Gender;
import com.appartementlocation.projet.enumeration.PublicCible;
import com.appartementlocation.projet.enumeration.StatusAnnonce;
import com.appartementlocation.projet.models.Annonce;
import com.appartementlocation.projet.models.Equipement;
import com.appartementlocation.projet.models.Facilite;
import com.appartementlocation.projet.models.Reglement;
import com.appartementlocation.projet.models.User;
import com.appartementlocation.projet.services.AnnonceService;
import com.appartementlocation.projet.services.EquipementService;
import com.appartementlocation.projet.services.FaciliteService;
import com.appartementlocation.projet.services.PhotosImmobilierService;
import com.appartementlocation.projet.services.ReglementService;
import com.appartementlocation.projet.services.UserService;



@SpringBootApplication
public class AppartementLocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppartementLocationApplication.class, args);
		new File(com.appartementlocation.projet.controllers.PhotosImmobilierController.uploadDirectory).mkdir();
		SpringApplication.run(com.appartementlocation.projet.controllers.PhotosImmobilierController.class, args);
	}

	@Bean
	CommandLineRunner run(UserService userService,EquipementService equipementService,ReglementService reglementService,FaciliteService faciliteService,PhotosImmobilierService photosImmobilierService,AnnonceService annonceService,PhotosImmobilierService photosImmobilierService1) {
		return args -> {
		
			
			
		
			
			equipementService.saveEquipement(new Equipement("TV"));
			equipementService.saveEquipement(new Equipement("Machine à laver"));
			equipementService.saveEquipement(new Equipement("Plaque vitrocéramique "));
			equipementService.saveEquipement(new Equipement("Hotte à évacuation"));
			
			reglementService.saveReglement(new Reglement("Respect du personnel de la résidence"));
			reglementService.saveReglement(new Reglement("Respect des locaux et matériel "));
			reglementService.saveReglement(new Reglement("Respect du travail et de la tranquillité des autres résidents"));
			reglementService.saveReglement(new Reglement("interdiction de fumer"));

			
			faciliteService.saveFacilite(new Facilite("ECOLE"));
			faciliteService.saveFacilite(new Facilite("HOPITAL"));
			faciliteService.saveFacilite(new Facilite("CENTRE COMMMERCIAL"));
			faciliteService.saveFacilite(new Facilite("GAME PARCK "));
			
			
			
			//annonceService.saveAnnonce(new Annonce("mon titre","mon discription",new Date(2021, 12, 10),500,2,PublicCible.HOMME,StatusAnnonce.DISPONIBLE,"av massira khadra",3,userService.getUser("yassine.chtiaa@gmail.com")));
			//annonceService.addEquipementToAnnonce(Integer.toUnsignedLong(19),Integer.toUnsignedLong(7));
			//annonceService.addFaciliteToAnnonce(Integer.toUnsignedLong(19),Integer.toUnsignedLong(15));
			//annonceService.addReglementToAnnonce(Integer.toUnsignedLong(19),Integer.toUnsignedLong(11));
			

			//photosImmobilierService1.savePhotosImmobilier(new PhotosImmobilier("bhsjdbhlasbjkhdasbhjvdbsljvbkjlbvkabslkasbkbv",annonceService.getAnnonce(Integer.toUnsignedLong(19))));
			
		};
}
	}
