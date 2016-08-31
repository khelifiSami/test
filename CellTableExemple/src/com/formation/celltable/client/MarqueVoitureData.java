package com.formation.celltable.client;


public class MarqueVoitureData {

	public static MarqueVoiture[] extract() {
		return new MarqueVoiture[] {
			new MarqueVoiture("Citroen","France",1919),
			new MarqueVoiture("Peugeot","France",1896),
			new MarqueVoiture("BMW","Allemagne",1916),
			new MarqueVoiture("Ford","USA",1903),
			new MarqueVoiture("Honda","Japon",1948),
			new MarqueVoiture("Toyota","Japon",1933)
		};
	}
}
