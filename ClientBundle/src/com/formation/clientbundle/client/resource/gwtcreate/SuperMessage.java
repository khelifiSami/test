package com.formation.clientbundle.client.resource.gwtcreate;


public class SuperMessage implements Commande {

	public SuperMessage(){

	}

	@Override
	public String executer(Object x) {
		return "Cette methode renvoie du texte passe en parametre :"+x;
	}

}
