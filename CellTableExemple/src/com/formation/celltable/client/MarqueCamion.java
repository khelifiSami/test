package com.formation.celltable.client;


import java.io.Serializable;

public class MarqueCamion  implements Serializable{
	
	private String 	marque;
	private String 	couleur;
	private int 	poid;
	
	
	public MarqueCamion(){
		
	}
	
	public MarqueCamion(String marque,String couleur,int poid){
		this.marque		=	marque;
		this.couleur	=	couleur;
		this.poid 		= 	poid;
				
		
	}
	
//	setter and getters
	
	public String getMarque() {
		return marque;
	}
	public void setMarque(String marque) {
		this.marque = marque;
	}
	public String getCouleur() {
		return couleur;
	}
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}
	public int getPoid() {
		return poid;
	}
	public void setPoid(int poid) {
		this.poid = poid;
	}
	
	
	

}
