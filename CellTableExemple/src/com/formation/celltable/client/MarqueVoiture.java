package com.formation.celltable.client;

import java.io.Serializable;


public class MarqueVoiture implements Serializable{

	private String nom;
	private String pays;
	private int anneeCreation;


	public MarqueVoiture(String nom, String pays, int anneeCreation) {
		super();
		this.nom = nom;
		this.pays = pays;
		this.anneeCreation = anneeCreation;
		
	}
	public MarqueVoiture() {
		
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}
	public int getAnneeCreation() {
		return anneeCreation;
	}
	public void setAnneeCreation(int anneeDeNaissance) {
		this.anneeCreation = anneeDeNaissance;
	}


	
}
