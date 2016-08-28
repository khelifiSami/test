package com.formation.adhesion.ods.web.shared.service;

import java.util.List;

import com.formation.adhesion.ods.core.model.Livre;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("livreService.rpc")
public interface LivreService extends RemoteService {
  
	public List<Livre> getLivres();
	public Livre getLivre(long id);
	public void deleteLivre(long id);
	public void updateLivre(Livre livre);
	 
	public static class Util { 
		private static LivreServiceAsync instance;
		public static LivreServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(LivreService.class);
			}
			return instance;
		}
	}
}
