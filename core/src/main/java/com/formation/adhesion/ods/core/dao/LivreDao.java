package com.formation.adhesion.ods.core.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.adhesion.ods.core.model.Livre;

@Repository
public class LivreDao {

	private final Logger log = Logger.getLogger(LivreDao.class);

	@PersistenceContext(unitName = "persistenceUnit")
	EntityManager entityManager;

	@Transactional()
	public void persist(Livre livre) {
		getEntityManager().persist(livre);
	}

	@Transactional()
	public void merge(Livre livre) {
		getEntityManager().merge(livre);
	}

	@Transactional
	public void remove(Livre livre) {

		if (getEntityManager().contains(livre)) {
			getEntityManager().remove(livre);
		} else {
			Livre attached = find(livre.getId());
			getEntityManager().remove(attached);
		}
	}

	public Livre find(Long id) {
		if (id == null)
			return null;
		return getEntityManager().find(Livre.class, id);
	}
	
	@Transactional
	public void delete(Long id) {
		if (id == null)
			return;
		Livre livre = find(id);
		if (livre != null) {
			getEntityManager().remove(livre);
		}
	}

	public final EntityManager getEntityManager() {
		if (entityManager == null)
			throw new IllegalStateException(
					"Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
		return entityManager;
	}

	public boolean contains(Livre livre) {
		return getEntityManager().contains(livre);
	}

	public List<Livre> getLivres() {

		return (List<Livre>) (getEntityManager().createQuery(
				"select object(l) from Livre l").getResultList());
	}

}
