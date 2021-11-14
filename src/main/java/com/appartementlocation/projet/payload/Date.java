package com.appartementlocation.projet.payload;

public class Date {
	private java.util.Date date_debut;
	private java.util.Date date_fin;
	public Date(java.util.Date date_debut, java.util.Date date_fin) {
		super();
		this.date_debut = date_debut;
		this.date_fin = date_fin;
	}
	public Date() {
		super();
	}
	public java.util.Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(java.util.Date date_debut) {
		this.date_debut = date_debut;
	}
	public java.util.Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(java.util.Date date_fin) {
		this.date_fin = date_fin;
	}


}
