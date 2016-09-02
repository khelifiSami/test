package com.formation.celltable.client;

public class MarqueCamionData {
	
	public MarqueCamionData(){
		
	}
	
	public static  MarqueCamion[] data(){
		return new MarqueCamion[]{new MarqueCamion("alfaromeo","bleu",3500),
				new MarqueCamion("citroen","noir",4500),
				new MarqueCamion("france","vert",2800)};
			
		
	}
}
