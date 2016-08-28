package com.formation.adhesion.ods.web.client.util;

public interface Step {

	public void execute();
	public void undo();
	public String getHistoryToken();
}
