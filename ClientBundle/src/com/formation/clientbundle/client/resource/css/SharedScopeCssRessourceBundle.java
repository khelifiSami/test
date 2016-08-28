package com.formation.clientbundle.client.resource.css;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;


public interface SharedScopeCssRessourceBundle extends ClientBundle{

	SharedScopeCssRessourceBundle INSTANCE = GWT.create(SharedScopeCssRessourceBundle.class);

	ActivableCssRessource sharedCss();
	CheckBoxCssRessource checkBoxCss();
	BoutonCssRessource boutonCss();



}
