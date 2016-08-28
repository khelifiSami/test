package com.formation.clientbundle.client.resource.pdf;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;

public interface PDFResource extends ClientBundle {
	PDFResource INSTANCE = GWT.create(PDFResource.class);

	@Source("YES.pdf")
	public DataResource yes();

}


