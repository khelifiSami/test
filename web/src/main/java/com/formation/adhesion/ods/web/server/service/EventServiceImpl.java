package com.formation.adhesion.ods.web.server.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.gwtrpcspring.RemoteServiceUtil;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.formation.adhesion.ods.core.dao.StatisticsDao;
import com.formation.adhesion.ods.web.shared.data.Event;
import com.formation.adhesion.ods.web.shared.service.EventService;

public class EventServiceImpl implements EventService {

	@Override
	public List<Event> getEvents(String type, int indexStart, int indexStop) {
		List<Event> alEvents = new ArrayList<Event>();
		for (int j = indexStart; j <= indexStop; j++) {
			alEvents.add(new Event(j, type + j, new Date()));
		}

	
		return alEvents;
	}

}
