package com.formation.adhesion.ods.web.server.service;

import com.formation.adhesion.ods.core.dao.DataLoaderDao;
import com.formation.adhesion.ods.web.shared.service.DataLoaderService;

public class DataLoaderServiceImpl implements DataLoaderService {


	
	private DataLoaderDao dataLoaderDao;

	@Override
	public void loadData() {
		dataLoaderDao.loadData();
		
	}

	public void setDataLoaderDao(DataLoaderDao dataLoaderDao) {
		this.dataLoaderDao = dataLoaderDao;
	}

	public DataLoaderDao getDataLoaderDao() {
		return dataLoaderDao;
	}

	

}
