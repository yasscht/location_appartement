package com.appartementlocation.projet.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.appartementlocation.projet.enumeration.PublicCible;
import com.appartementlocation.projet.enumeration.StatusAnnonce;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "annonces")
public class Annonce {
	
	
	@Id @GeneratedValue(strategy =GenerationType.AUTO )
	private Long id;
	@Column(name = "title")
	private String title;
	@Column(name = "description")
	private String description;
	@Column(name = "date_disponibilite")
	private Date dateDisponibilite;
	@Column(name = "prix_mois")
	private float prixMois;

	@Column(name = "nombre_personnes")
	private int nombrePersonnes;
	@Enumerated(EnumType.STRING)
	private PublicCible publicCible;
	@Enumerated(EnumType.STRING)
	private StatusAnnonce status;
	
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "etage")
	private int etage;
	
	@Column(name = "is_deleted")
	private boolean isDeleted;
	
	
//	@ManyToOne(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)

	@ManyToOne
    @JoinColumn(name = "user_id")
//	referencedColumnName = "id"
	private User user;
	
	@ManyToMany
	private Collection<Equipement> equipement = new ArrayList<>();
	
	@ManyToMany
	private Collection<Reglement> reglement = new ArrayList<>();
	
	@ManyToMany
	private Collection<Facilite> facilite = new ArrayList<>();
	
	@ManyToMany
	@JoinColumn(name = "photos_immobilier_id")
	private Collection<PhotosImmobilier> photosImmobilier = new ArrayList<>();
	

	
	@Column(name = "created_at")
	private LocalDateTime created_at = LocalDateTime.now();
	@Column(name = "updated_at",nullable = true)
	private LocalDateTime updated_at;
	@Column(name = "deleted_at",nullable = true)
	private LocalDateTime deleted_at;
	

	
	public Annonce(String title, String description, Date dateDisponibilite, float prixMois,
			int nombrePersonnes, PublicCible publicCible, StatusAnnonce status, String adresse, int etage,
			boolean isDeleted, User user, Collection<Equipement> equipement, Collection<Reglement> reglement,
			Collection<Facilite> facilite, Collection<PhotosImmobilier> photosImmobilier) {
		super();
		this.title = title;
		this.description = description;
		this.dateDisponibilite = dateDisponibilite;
		this.prixMois = prixMois;
		this.nombrePersonnes = nombrePersonnes;
		this.publicCible = publicCible;
		this.status = status;
		this.adresse = adresse;
		this.etage = etage;
		this.isDeleted = isDeleted;
		this.user = user;
		this.equipement = equipement;
		this.reglement = reglement;
		this.facilite = facilite;
		this.photosImmobilier = photosImmobilier;
	}
	
	
	
	
	public Annonce(String title, String description, Date dateDisponibilite, float prixMois,
			int nombrePersonnes, PublicCible publicCible, StatusAnnonce status, String adresse, int etage, User user) {
		super();
		this.title = title;
		this.description = description;
		this.dateDisponibilite = dateDisponibilite;
		this.prixMois = prixMois;
		this.nombrePersonnes = nombrePersonnes;
		this.publicCible = publicCible;
		this.status = status;
		this.adresse = adresse;
		this.etage = etage;
		this.user = user;
	}









	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateDisponibilite() {
		return dateDisponibilite;
	}
	public void setDateDisponibilite(Date dateDisponibilite) {
		this.dateDisponibilite = dateDisponibilite;
	}
	public float getPrixMois() {
		return prixMois;
	}
	public void setPrixMois(float prixMois) {
		this.prixMois = prixMois;
	}
	public int getNombrePersonnes() {
		return nombrePersonnes;
	}
	public void setNombrePersonnes(int nombrePersonnes) {
		this.nombrePersonnes = nombrePersonnes;
	}
	public PublicCible getPublicCible() {
		return publicCible;
	}
	public void setPublicCible(PublicCible publicCible) {
		this.publicCible = publicCible;
	}
	public StatusAnnonce getStatus() {
		return status;
	}
	public void setStatus(StatusAnnonce status) {
		this.status = status;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getEtage() {
		return etage;
	}
	public void setEtage(int etage) {
		this.etage = etage;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Collection<Equipement> getEquipement() {
		return equipement;
	}
	public void setEquipement(Collection<Equipement> equipement) {
		this.equipement = equipement;
	}
	public Collection<Reglement> getReglement() {
		return reglement;
	}
	public void setReglement(Collection<Reglement> reglement) {
		this.reglement = reglement;
	}
	public LocalDateTime getCreated_at() {
		return created_at;
	}
	public void setCreated_at(LocalDateTime created_at) {
		this.created_at = created_at;
	}
	public LocalDateTime getUpdated_at() {
		return updated_at;
	}
	public void setUpdated_at(LocalDateTime updated_at) {
		this.updated_at = updated_at;
	}
	public LocalDateTime getDeleted_at() {
		return deleted_at;
	}
	public void setDeleted_at(LocalDateTime deleted_at) {
		this.deleted_at = deleted_at;
	}


	public Collection<Facilite> getFacilite() {
		return facilite;
	}


	public void setFacilite(Collection<Facilite> facilite) {
		this.facilite = facilite;
	}


	public Collection<PhotosImmobilier> getPhotosImmobilier() {
		return photosImmobilier;
	}


	public void setPhotosImmobilier(Collection<PhotosImmobilier> photosImmobilier) {
		this.photosImmobilier = photosImmobilier;
	}




	public Annonce() {
		super();
	}
	

	
	

}
