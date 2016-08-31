package com.formation.celltable.client.image;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface MyImageBunleCamion extends ClientBundle{
	
	public  final static MyImageBunleCamion  INSTANCE_CAMION = GWT.create(MyImageBunleCamion.class);
	ImageResource alfaromeo();
	ImageResource citroen();
	ImageResource france();
	ImageResource toyota();
	ImageResource peugeot();
	
}
