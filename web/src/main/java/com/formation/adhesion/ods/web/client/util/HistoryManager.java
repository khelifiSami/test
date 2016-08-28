package com.formation.adhesion.ods.web.client.util;

import java.util.LinkedList;
import java.util.List;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;

public class HistoryManager implements ValueChangeHandler<String> {

	private List<Step> steps;
	private static HistoryManager instance;
	
	protected HistoryManager() {
		steps = new LinkedList<Step>();
		History.addValueChangeHandler(this);
	}
	public static HistoryManager get() {
		if (instance == null) {
			instance = new HistoryManager();
		}
		return instance;
	}
	public void doStep(Step step){
		Step currentStep = findStep(History.getToken());
		int indexCurrentStep = steps.indexOf(currentStep);
	
		for(int i = indexCurrentStep;indexCurrentStep != -1 && i != 0;i--){
			steps.remove(0);
		}
		
		steps.add(0,step);
		History.newItem(step.getHistoryToken(),false);
		step.execute();
	}
	
	public void undoStep(String historyToken){
	
		Step step = findStep(historyToken);
		steps.remove(historyToken);
		step.undo();
	}

	
	private Step findStep(String historyToken) {
		for (Step step : steps) {
			if(step.getHistoryToken().equals(historyToken))
				return step;
		}
		return null;
	}

	@Override
	public void onValueChange(ValueChangeEvent<String> event) {
		String historyToken = event.getValue();

		Step step = findStep(historyToken);
		if (step != null){
			step.execute();
		} else {
			// token instrouvable...
			// dans ce cas on reviens arbitrairement a la naissance ... au premier pas
			steps.get(steps.size()-1).execute();
		}
			
	}


	
}
