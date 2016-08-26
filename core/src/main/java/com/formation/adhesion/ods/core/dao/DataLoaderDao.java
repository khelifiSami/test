package com.formation.adhesion.ods.core.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.adhesion.ods.core.model.Livre;
import com.formation.adhesion.ods.core.model.Statistics;

@Repository
public class DataLoaderDao {
	private StatisticsDao statisticsDao;
	private LivreDao livreDao;
//test git
	public LivreDao getLivreDao() {
		return livreDao;
	}

	public void setLivreDao(LivreDao livreDao) {
		this.livreDao = livreDao;
	}

	@PersistenceContext(unitName = "persistenceUnit")
	EntityManager entityManager;


	public StatisticsDao getStatisticsDao() {
		return statisticsDao;
	}

	public void setStatisticsDao(StatisticsDao statisticDao) {
		this.statisticsDao = statisticDao;
	}
	
	@Transactional()
	public void loadData()  {
		Statistics statistics = new Statistics();

		statistics.setAverageduration(1L);
		statistics.setClientapp("cliapp");
		statistics.setClientidentity("clitity");
		statistics.setConnectiontype("1");
		statistics.setDayofyear("152");
		statistics.setDomain("domain");
		statistics.setExecutionenvironment("X");
		statistics.setGeographicsite("geo");
		statistics.setHourslot("01");
		statistics.setMaximumduration(1L);
		statistics.setMinimumduration(1L);
		statistics.setNumberbelow100(1L);
		statistics.setNumberbetween1000030000(1L);
		statistics.setNumberbetween10002000(1L);
		statistics.setNumberbetween100500(1L);
		statistics.setNumberbetween20005000(1L);
		statistics.setNumberbetween500010000(1L);
		statistics.setNumberbetween5001000(1L);
		statistics.setNumberofbytes(1L);
		statistics.setNumberoferrors(1L);
		statistics.setNumberofservice(1L);
		statistics.setNumberupper30000(1L);
		statistics.setOriginetype("O");
		statistics.setProtocol("p");
		statistics.setServerapp("S");
		statistics.setServername("servername");
		statistics.setServicenumber("1");
		statistics.setTechnotype("t");
		statistics.setValuelevel("v");

		statisticsDao.persist(statistics);
		
		livreDao.persist(new Livre("L'art du developpement Android"));
		livreDao.persist(new Livre("Merise et UML"));
		livreDao.persist(new Livre("La prophetie des Andes"));
		livreDao.persist(new Livre("L'enchanteur"));
		livreDao.persist(new Livre("Chat blanc, Chat noir"));
		livreDao.persist(new Livre("200 recettes minceurs"));
		livreDao.persist(new Livre("La psychologie pour les cons"));
		System.out.println("Fin de chargement");
		
	}
}
