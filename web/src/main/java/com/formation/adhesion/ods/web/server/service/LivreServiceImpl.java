package com.formation.adhesion.ods.web.server.service;

import java.util.List;

import com.formation.adhesion.ods.core.dao.LivreDao;
import com.formation.adhesion.ods.core.model.Livre;
import com.formation.adhesion.ods.web.shared.service.LivreService;

public class LivreServiceImpl implements LivreService {

	private LivreDao livreDao;

	@Override
	public List<Livre> getLivres() {

		return livreDao.getLivres();
	}

	@Override
	public Livre getLivre(long id) {

		return livreDao.find(id);
	}

	public void setLivreDao(LivreDao livreDao) {
		this.livreDao = livreDao;
	}

	public LivreDao getLivreDao() {
		return livreDao;
	}

	@Override
	public void deleteLivre(long id) {
		livreDao.delete(id);
	}

	@Override
	public void updateLivre(Livre livre) {
		livreDao.merge(livre);
		
	}
	
	

}
