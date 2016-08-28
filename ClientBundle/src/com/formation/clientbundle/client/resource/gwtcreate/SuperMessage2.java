package com.formation.clientbundle.client.resource.gwtcreate;


public class SuperMessage2 implements Commande {

	public SuperMessage2(){

	}

	@Override
	public String executer(Object x) {
		return "Cette methode renvoie du texte passe en parametre mais pas pareil ("+x+")";
	}

}
