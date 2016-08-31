package com.formation.deferedbinding.client;



import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class DeferedBindingExemple implements EntryPoint {
	
	public void onModuleLoad() {
		
	System.out.println("oo");
	System.out.println("avant");
		Operation ope = (Operation) GWT.create(Operation.class);
		System.out.println("calcul");
		System.out.println("="+ope.calcul(15, 6));
		RootPanel.get("monModule").add(
		 new Label("Resultat(15,6) : "+ope.calcul(15, 6)),0,0);	
	}
}
