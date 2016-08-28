package com.formation.clientbundle.client.resource.css;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.resources.client.ImageResource.ImageOptions;
import com.google.gwt.resources.client.ImageResource.RepeatStyle;

public interface MyCssBundle extends ClientBundle {
	MyCssBundle INSTANCE = GWT.create(MyCssBundle.class);

	// par defaut le nom de la css est celui de la méthode (en ajoutant .css)
	// ici myCss.css
	//@Source("myCss.css") permet de redefinir le nom du fichier css de liaison
	//
	//@CssResource.NotStrict // autorise le style mb77 qui n'est jamais utilisé
	@ImageOptions(repeatStyle=RepeatStyle.Horizontal)
	MyCssResource myCss();

	@Source("icon_smile.gif")
	@ImageOptions(repeatStyle=RepeatStyle.Horizontal)
	ImageResource iconSmile();


}
