package com.appartementlocation.projet.models;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.appartementlocation.projet.enumeration.Gender;



@Entity
public class User {

   @Id

   private String userName;
	private String firstName;
	private String lastName;
	private String email;

	private String phone;
	private String password;
	private LocalDateTime createdAt = LocalDateTime.now();
	@Column(name = "updated_at",nullable = true)
	private LocalDateTime updatedAt;
	@Column(name = "deleted_at",nullable = true)
	private LocalDateTime deletedAt;
	@Enumerated(EnumType.STRING)
	private Gender gender;
	@Column(name = "adresse",nullable = true)
	private String adresse;
	@Column(name = "photo",nullable = true)
	private String photo;
@OneToMany
private Set<Annonce> annonces =new HashSet<>();

@OneToMany
private Set<Demand> demands =new HashSet<>();

	public User(String userName, String firstName, String lastName, String email, String phone, String password,
		LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt, Gender gender, String adresse,
		String photo, Set<Annonce> annonces,Set<Demand> demands, String ville, Set<Role> role) {
	super();
	this.userName = userName;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.phone = phone;
	this.password = password;
	this.createdAt = createdAt;
	this.updatedAt = updatedAt;
	this.deletedAt = deletedAt;
	this.gender = gender;
	this.adresse = adresse;
	this.photo = photo;
	this.annonces = annonces;
	this.ville = ville;
	this.role = role;
	this.demands = demands;
}
	public Set<Annonce> getAnnonces() {
	return annonces;
}
public void setAnnonces(Set<Annonce> annonces) {
	this.annonces = annonces;
}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public LocalDateTime getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(LocalDateTime updatedAt) {
		this.updatedAt = updatedAt;
	}
	public LocalDateTime getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(LocalDateTime deletedAt) {
		this.deletedAt = deletedAt;
	}
	public Gender getGender() {
		return gender;
	}
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	private String ville;
	@ManyToMany(fetch=FetchType.EAGER,cascade=CascadeType.ALL)
	@JoinTable(name="USER_ROLE",
			joinColumns= {
					@JoinColumn(name="USER_ID")
			},
			inverseJoinColumns={
		@JoinColumn(name="ROLE_ID")
		
			}
			)
	
	private Set<Role> role;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<Role> getRole() {
		return role;
	}
	public void setRole(Set<Role> role) {
		this.role = role;
	}
	public User(String userName, String firstName, String lastName, String email, String password, Set<Role> role) {
		super();
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.role = role;
	}
	public User(String userName, String firstName, String lastName, String email, String phone,
			String password, LocalDateTime createdAt, LocalDateTime updatedAt, LocalDateTime deletedAt,
			Gender gender, String adresse, String photo, String ville,
			Set<Role> role) {
		super();
	
		this.userName = userName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.deletedAt = deletedAt;
		this.gender = gender;
		this.adresse = adresse;
		this.photo = photo;
		this.ville = ville;
		this.role = role;
	}
	public User() {
		super();
	}
	public Set<Demand> getDemands() {
		return demands;
	}
	public void setDemands(Set<Demand> demands) {
		this.demands = demands;
	}
	
	
	

}
