package com.formation.adhesion.ods.core.dao;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.formation.adhesion.ods.core.model.Statistics;

@Repository
public class StatisticsDao {

	private final Logger log = Logger.getLogger(StatisticsDao.class);

	@PersistenceContext(unitName = "persistenceUnit")
	EntityManager entityManager;

	@Transactional()
	public void persist(Statistics statistics) {
			getEntityManager().persist(statistics);
	}
	
	@Transactional()
	public void merge(Statistics statistics) {
			getEntityManager().merge(statistics);
	}

	@Transactional
	public void remove(Statistics statistics) {

		if (getEntityManager().contains(statistics)) {
			getEntityManager().remove(statistics);
		} else {
			Statistics attached = find(statistics.getId());
			getEntityManager().remove(attached);
		}
	}

	public Statistics find(Long id) {
		if (id == null)
			return null;
		return getEntityManager().find(Statistics.class, id);
	}
	
	public List<Statistics> findWithKey(Statistics statistics) {
		StringBuilder sb = new StringBuilder();
		sb.append("select object(s) from Statistics s");
		sb.append(" where s.dayofyear = :dayOfYear");		
		sb.append(" and s.hourslot = :hourslot");
		sb.append(" and s.servicenumber = :servicenumber");
		sb.append(" and s.originetype = :originetype");
		sb.append(" and s.clientapp = :clientapp");
		sb.append(" and s.domain = :domain");
		sb.append(" and s.valuelevel = :valuelevel");
		sb.append(" and s.clientidentity = :clientidentity");
		sb.append(" and s.serverapp = :serverapp");
		sb.append(" and s.connectiontype = :connectiontype");
		sb.append(" and s.protocol = :protocol");
		sb.append(" and s.geographicsite = :geographicsite");
		sb.append(" and s.technotype = :technotype");
		sb.append(" and s.servername = :servername");
		sb.append(" and s.executionenvironment = :executionenvironment");
		
		Query query = getEntityManager().createQuery(sb.toString());
		query.setParameter("dayOfYear", statistics.getDayofyear());
		query.setParameter("hourslot", statistics.getHourslot());
		query.setParameter("servicenumber", statistics.getServicenumber());
		query.setParameter("originetype", statistics.getOriginetype());
		query.setParameter("clientapp", statistics.getClientapp());
		query.setParameter("domain", statistics.getDomain());
		query.setParameter("valuelevel", statistics.getValuelevel());
		query.setParameter("clientidentity", statistics.getClientidentity());
		query.setParameter("serverapp", statistics.getServerapp());
		query.setParameter("connectiontype", statistics.getConnectiontype());
		query.setParameter("protocol", statistics.getProtocol());
		query.setParameter("geographicsite", statistics.getGeographicsite());
		query.setParameter("technotype", statistics.getTechnotype());
		query.setParameter("servername", statistics.getServername());
		query.setParameter("executionenvironment", statistics.getExecutionenvironment());
		return query.getResultList(); 
		
		
		
	}
	
	
	
	
	
	
	public List<Statistics> find(String dayOfYear, String serviceNumber ) {
		StringBuilder sb = new StringBuilder();
		sb.append("select object(s) from Statistics s");
		sb.append(" where s.dayofyear = :dayOfYear");
		sb.append(" and trim(s.servicenumber) = :serviceNumber");
		Query query = getEntityManager().createQuery(sb.toString());
		query.setParameter("dayOfYear", dayOfYear);
		query.setParameter("serviceNumber", serviceNumber.trim());

		return query.getResultList();
		
		
		
		
	}

	public final EntityManager getEntityManager() {
		if (entityManager == null)
			throw new IllegalStateException(
					"Entity manager has not been injected (is the Spring Aspects JAR configured as an AJC/AJDT aspects library?)");
		return entityManager;
	}


	public boolean contains(Statistics statistics) {
		return getEntityManager().contains(statistics);
	}


}
