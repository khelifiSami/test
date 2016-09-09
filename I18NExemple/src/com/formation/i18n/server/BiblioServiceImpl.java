package com.formation.i18n.server;

import com.formation.i18n.client.BiblioService;
import com.formation.i18n.client.Livre;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

@SuppressWarnings("serial")
public class BiblioServiceImpl extends RemoteServiceServlet implements BiblioService{


	@Override
	public Livre getLivre(int numero) {
		LivresDonnees ld = new LivresDonnees();
		return ld.getLivre(numero);
	}

	
	public Livre[] getLivres() {
		LivresDonnees ld = new LivresDonnees();
		return ld.getLivres();
	}

}
