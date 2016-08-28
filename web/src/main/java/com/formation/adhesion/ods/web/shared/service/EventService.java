package com.formation.adhesion.ods.web.shared.service;

import java.util.List;

import com.formation.adhesion.ods.web.shared.data.Event;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("EventService.rpc")
public interface EventService extends RemoteService {
  
	public List<Event> getEvents(String type, int indexStart,int  indexStop);
	
	 
	public static class Util { 
		private static EventServiceAsync instance;
		public static EventServiceAsync getInstance(){
			if (instance == null) {
				instance = GWT.create(EventService.class);
			}
			return instance;
		}
	}
}
