package com.formation.clientbundle.client.resource.image;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface ImageRessourceBundle extends ClientBundle {

	ImageRessourceBundle INSTANCE = (ImageRessourceBundle) GWT
			.create(ImageRessourceBundle.class);

	@Source("imageA.gif")
	ImageResource imageA();

	@Source("imageB.gif")
	ImageResource imageB();
}


