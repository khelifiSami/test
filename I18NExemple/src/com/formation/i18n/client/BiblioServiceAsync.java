package com.formation.i18n.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface BiblioServiceAsync {



	void getLivres(AsyncCallback<Livre[]> callback);

	void getLivre(int numero, AsyncCallback<Livre> callback);
}
