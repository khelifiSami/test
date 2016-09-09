package com.formation.i18n.client;

import java.util.Date;

import com.google.gwt.i18n.client.Messages;

public interface TraductionMessages extends Messages{

	@DefaultMessage("Your name is {0}.")
	String message1(String name);
	
	  @DefaultMessage("Today  {0,date,medium} {0,time,medium}")
	  String today(Date timestamp);
}
