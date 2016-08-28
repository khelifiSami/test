package com.formation.clientbundle.client.resource.texte;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ExternalTextResource;
import com.google.gwt.resources.client.TextResource;

public interface TextResourceBundle extends ClientBundle {

	TextResourceBundle INSTANCE = GWT.create(TextResourceBundle.class);

	@Source("a.txt")
	TextResource getASynchrone();
 
	@Source("b.txt")
	ExternalTextResource getBAsynchrone();
}


