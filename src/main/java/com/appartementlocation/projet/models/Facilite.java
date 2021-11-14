package com.appartementlocation.projet.models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
@Table(name = "facilites")
public class Facilite {
	
	@Id @GeneratedValue(strategy =GenerationType.AUTO )
	private Long id;
	@Column(name = "Facilite_name")
	private String FaciliteName;
	@Column(name = "created_at")
	private LocalDateTime created_at = LocalDateTime.now();
	@Column(name = "updated_at",nullable = true)
	private LocalDateTime updated_at;
	@Column(name = "deleted_at",nullable = true)
	private LocalDateTime deleted_at;
	
	
	public String getFaciliteName() {
		return FaciliteName;
	}
	public void setFaciliteName(String faciliteName) {
		FaciliteName = faciliteName;
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
	public Facilite(String faciliteName) {
		super();
		FaciliteName = faciliteName;
	}
	public Facilite() {
		super();
	}
	public Long getId() {
		return id;
	}
	
	
	

}
