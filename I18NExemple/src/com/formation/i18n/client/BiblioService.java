package com.formation.i18n.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("biblio")
public interface BiblioService extends RemoteService {
	public Livre getLivre(int numero);

	public Livre[] getLivres();

}
