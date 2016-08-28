package com.formation.adhesion.ods.web.shared.service;


import com.formation.adhesion.ods.core.model.Statistics;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("StatisticService.rpc")
public interface StatisticService extends RemoteService {
	 
	public Statistics persist(Statistics stat);
	 
	public Statistics getStatistics(long id);
	
	public static class Util { 
		private static StatisticServiceAsync instance;
		public static StatisticServiceAsync getInstance(){ 
			if (instance == null) {
			instance = GWT.create(StatisticService.class);
			}
			return instance;
		}
	}


}
