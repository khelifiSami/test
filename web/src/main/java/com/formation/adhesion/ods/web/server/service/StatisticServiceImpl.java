package com.formation.adhesion.ods.web.server.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.formation.adhesion.ods.core.dao.StatisticsDao;
import com.formation.adhesion.ods.core.model.Statistics;
import com.formation.adhesion.ods.web.shared.service.StatisticService;
 
public class StatisticServiceImpl implements StatisticService {

	private StatisticsDao statisticsDao;


	private double findNumberOfServices(List<Statistics> stats,
			String originType, String hourSlot) {
		double numberOfService = 0;
		for (Iterator statsIterator = stats.iterator(); statsIterator.hasNext();) {
			Statistics stat = (Statistics) statsIterator.next();
			if (stat.getHourslot().equals(hourSlot)
					&& stat.getOriginetype().equals(originType)) {
				numberOfService += stat.getNumberofservice();
			}
		}
		return numberOfService;
	}

	private List<String> findOriginType(List<Statistics> stats) {
		ArrayList<String> originTypes = new ArrayList<String>();
		for (Iterator statsIterator = stats.iterator(); statsIterator.hasNext();) {
			Statistics stat = (Statistics) statsIterator.next();

			if (!originTypes.contains(stat.getOriginetype())) {
				originTypes.add(stat.getOriginetype());
			}

		}
		return originTypes;
	}

	private List<String> findHourSlots(List<Statistics> stats) {
		ArrayList<String> hourSlots = new ArrayList<String>();
		for (Iterator statsIterator = stats.iterator(); statsIterator.hasNext();) {
			Statistics stat = (Statistics) statsIterator.next();

			if (!hourSlots.contains(stat.getHourslot())) {
				hourSlots.add(stat.getHourslot());
			}

		}
		return hourSlots;
	}

	public void setStatisticsDao(StatisticsDao statisticsDao) {
		this.statisticsDao = statisticsDao;
	}

	public StatisticsDao getStatisticsDao() {
		return statisticsDao;
	}

	@Override
	public Statistics getStatistics(long id) {
		
		return statisticsDao.find(id);
	}

	@Override
	public Statistics persist(Statistics stat) {
		
		 statisticsDao.persist(stat);
		 return stat;
	}


}
