package com.formation.adhesion.ods.web.client.util;

import java.util.Date;

public  abstract class AbstractStep implements Step {
	
	private String historyToken;
	
	public AbstractStep(){
		historyToken = String.valueOf((new Date()).getTime());
	}

	@Override
	public String getHistoryToken() {
		return historyToken;
	}
	
	@Override
	public void undo() {	}
}
