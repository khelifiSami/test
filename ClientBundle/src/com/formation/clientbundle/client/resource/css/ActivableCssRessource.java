package com.formation.clientbundle.client.resource.css;

import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.Shared;

@Shared
public interface ActivableCssRessource extends CssResource {

	public String activer();
	public String desactiver();

}
