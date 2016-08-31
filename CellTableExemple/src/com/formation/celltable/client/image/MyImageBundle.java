package com.formation.celltable.client.image;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.ImageResource;

public interface MyImageBundle extends ClientBundle{

	public  final static MyImageBundle INSTANCE = GWT.create(MyImageBundle.class);
	ImageResource bmw();
	ImageResource ford();
	ImageResource honda();
	ImageResource citroen();
	ImageResource alfaromeo();
}
