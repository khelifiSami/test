package com.formation.adhesion.ods.web.shared.service;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;
@RemoteServiceRelativePath("dataLoaderService.rpc")
public interface DataLoaderService extends RemoteService {

	public void loadData();
	public static class Util { 
		private static DataLoaderServiceAsync instance;
		public static DataLoaderServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(DataLoaderService.class);
			}
			return instance;
		}
	}
}
