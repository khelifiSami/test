package com.formation.clientbundle.client.resource.gwtcreate;


import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.GwtCreateResource;
import com.google.gwt.resources.client.GwtCreateResource.ClassType;

public interface GwtCreateResourceBundle extends ClientBundle {
	GwtCreateResourceBundle INSTANCE = GWT
			.create(GwtCreateResourceBundle.class);

	@ClassType(SuperMessage.class)
	GwtCreateResource<Commande> creerCommandeNumero1();



}
