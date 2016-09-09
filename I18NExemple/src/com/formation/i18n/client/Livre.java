package com.formation.i18n.client;


@SuppressWarnings("serial")
public class Livre implements java.io.Serializable {
	private int numero;
	private String titre;
	private String auteur;
	private String editeur;
	public Livre(){
		
	}
	public Livre(int numero, String titre, String auteur, String editeur) {
		super();
		this.numero = numero;
		this.titre = titre;
		this.auteur = auteur;
		this.editeur = editeur;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public int getNumero() {
		return numero;
	}
	
	
}
