package com.formation.adhesion.ods.core.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Bean entite Livre
 * 
 */
@Entity
@Table(name = "LIVRE")
public class Livre implements Serializable{

	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "LVR_SEQ")
	@SequenceGenerator(name = "LVR_SEQ", sequenceName = "LVR_SEQ")
	@Id
	private Long id;

	@Column(name = "titre", nullable = false, length = 150)
	private String titre;

	public Livre(Long id, String titre) {
		super();
		this.id = id;
		this.titre = titre;
	}

	public Livre() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public Livre(String titre) {
		super();
		this.titre = titre;
	}

	@Override
	public String toString() {
		return "Livre [id=" + id + ", titre=" + titre + "]";
	}

}
