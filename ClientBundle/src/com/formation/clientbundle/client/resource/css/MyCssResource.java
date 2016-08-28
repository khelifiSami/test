package com.formation.clientbundle.client.resource.css;

import com.google.gwt.resources.client.CssResource;

public interface MyCssResource extends CssResource {

	public String small();

	public String noire();

	@ClassName("mb")
	String mbClass();

	@ClassName("mb2")
	String mb2Class();

	String mb3();

	String mb4();

	@ClassName("mb5")
	String mb5Class();

	@ClassName("mb6")
	String mb6Class();

}