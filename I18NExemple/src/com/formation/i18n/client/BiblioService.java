package com.formation.i18n.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("biblio")
public interface BiblioService extends RemoteService {
	public Livre getLivre(int numero);
//	jadd to index
//	J4AJOUTE PAS AU INDEX

	public Livre[] getLivres();

}
