package com.appartementlocation.projet.models;

import java.sql.Date;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	private Date dateDebutLocation;
	@Column(name = "date_fin_location")
	private Date dateFinLocation;
	@Column(name = "nombre_personnes")
	private int NombrePersonnes;

	@Enumerated(EnumType.STRING)
	private Gender genre;
	
	@Enumerated(EnumType.STRING)
	private StatusDemand status = StatusDemand.PENDING;
	
//	@ManyToOne(fetch = FetchType.LAZY,
//            cascade = CascadeType.ALL)
//	@JoinColumn(name = "annonce_id")
//	
////	 @ManyToOne(cascade = CascadeType.MERGE)
////    @JoinColumn(name = "annonce_id", nullable = false)
	@ManyToOne
    @JoinColumn(name = "annonce_id")
   	private Annonce annonce;

//	@ManyToOne(fetch = FetchType.LAZY,
//        cascade = CascadeType.ALL)
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;

	@Column(name = "created_at")
	private LocalDateTime created_at = LocalDateTime.now();
	@Column(name = "updated_at",nullable = true)
	private LocalDateTime updated_at;
	@Column(name = "deleted_at",nullable = true)
	private LocalDateTime deleted_at;
	
	
	
	
	
	
	
	
	public Demand(Date dateDebutLocation, Date dateFinLocation, int nombrePersonnes, Gender genre,
		 Annonce annonce, User user) {
		super();
		this.dateDebutLocation = dateDebutLocation;
		this.dateFinLocation = dateFinLocation;
		NombrePersonnes = nombrePersonnes;
		this.genre = genre;
		
		this.annonce = annonce;
		this.user = user;
	}
	public Date getDateDebutLocation() {
		return dateDebutLocation;
	}
	public void setDateDebutLocation(Date dateDebutLocation) {
		this.dateDebutLocation = dateDebutLocation;
	}
	public Date getDateFinLocation() {
		return dateFinLocation;
	}
	public void setDateFinLocation(Date dateFinLocation) {
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
	public Demand() {
		super();
	}
	
	
}
