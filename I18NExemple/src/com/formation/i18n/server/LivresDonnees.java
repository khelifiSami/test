package com.formation.i18n.server;

import java.util.ArrayList;
import java.util.List;

import com.formation.i18n.client.Livre;

public class LivresDonnees {

	private List<Livre> livres;
	
	public LivresDonnees() {
		livres = new ArrayList<Livre>();
		livres.add(new Livre(1,"L'enchanteur","Romain Gary","Gallimard"));

		livres.add(new Livre(2,"La peste","Camu Alber","Livre de poche"));
		livres.add(new Livre(3,"Les fourmis","Weber Bernard","Librairie Générale Française"));
		livres.add(new Livre(4,"Le parfum","Süskind Patrick","Librairie Générale Française"));
		livres.add(new Livre(5,"Le Petit Nicolas","Jean-Jacques Sempé","Gallimard")) ;
	}
	
	public Livre getLivre(int numero){
		return livres.get(numero);
	}
	
	public Livre[] getLivres() {
		Livre[] aLivres = new Livre[livres.size()];
		return livres.toArray(aLivres);
	}
}
