package com.appartementlocation.projet.models;

import java.time.LocalDateTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.appartementlocation.projet.enumeration.Gender;
import com.appartementlocation.projet.enumeration.StatusDemand;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "demands")
public class Demand {
	
	@Id @GeneratedValue(strategy =GenerationType.AUTO )
	private Long id;
	@Column(name = "date_debut_location")
	private LocalDateTime dateDebutLocation;
	@Column(name = "date_fin_location")
	private LocalDateTime dateFinLocation;
	@Column(name = "nombre_personnes")
	private int NombrePersonnes;

	@Enumerated(EnumType.STRING)
	private Gender genre;
	
	@Enumerated(EnumType.STRING)
	private StatusDemand status;
	
	@ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
	private Annonce annonce;

	@ManyToOne(fetch = FetchType.LAZY,
        cascade = CascadeType.ALL)
	private User user;

	@Column(name = "created_at")
	private LocalDateTime created_at = LocalDateTime.now();
	@Column(name = "updated_at",nullable = true)
	private LocalDateTime updated_at;
	@Column(name = "deleted_at",nullable = true)
	private LocalDateTime deleted_at;
	public Demand(LocalDateTime dateDebutLocation, LocalDateTime dateFinLocation, int nombrePersonnes, Gender genre,
			StatusDemand status, Annonce annonce, User user) {
		super();
		this.dateDebutLocation = dateDebutLocation;
		this.dateFinLocation = dateFinLocation;
		NombrePersonnes = nombrePersonnes;
		this.genre = genre;
		this.status = status;
		this.annonce = annonce;
		this.user = user;
	}
	public LocalDateTime getDateDebutLocation() {
		return dateDebutLocation;
	}
	public void setDateDebutLocation(LocalDateTime dateDebutLocation) {
		this.dateDebutLocation = dateDebutLocation;
	}
	public LocalDateTime getDateFinLocation() {
		return dateFinLocation;
	}
	public void setDateFinLocation(LocalDateTime dateFinLocation) {
		this.dateFinLocation = dateFinLocation;
	}
	public int getNombrePersonnes() {
		return NombrePersonnes;
	}
	public void setNombrePersonnes(int nombrePersonnes) {
		NombrePersonnes = nombrePersonnes;
	}
	public Gender getGenre() {
		return genre;
	}
	public void setGenre(Gender genre) {
		this.genre = genre;
	}
	public StatusDemand getStatus() {
		return status;
	}
	public void setStatus(StatusDemand status) {
		this.status = status;
	}
	public Annonce getAnnonce() {
		return annonce;
	}
	public void setAnnonce(Annonce annonce) {
		this.annonce = annonce;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
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
	
	
}
