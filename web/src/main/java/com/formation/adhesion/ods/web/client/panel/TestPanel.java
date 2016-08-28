package com.formation.adhesion.ods.web.client.panel;

import java.util.List;

import com.formation.adhesion.ods.core.model.Livre;
import com.formation.adhesion.ods.core.model.Statistics;
import com.formation.adhesion.ods.web.shared.service.DataLoaderService;
import com.formation.adhesion.ods.web.shared.service.LivreService;
import com.formation.adhesion.ods.web.shared.service.StatisticService;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class TestPanel extends Composite  {

	private static TestPanelUiBinder uiBinder = GWT
			.create(TestPanelUiBinder.class);
	@UiField Button button;

	interface TestPanelUiBinder extends UiBinder<Widget, TestPanel> {
	}

	public TestPanel() {
		initWidget(uiBinder.createAndBindUi(this));
		DataLoaderService.Util.getInstance().loadData( new AsyncCallback<Void>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Erreur chargement :"+caught);
				
			}

			@Override
			public void onSuccess(Void result) {
				
				Window.alert("Données chargées");
			}
		
		});
		
		LivreService.Util.getInstance().getLivres(new AsyncCallback<List<Livre>>() {

			@Override
			public void onFailure(Throwable caught) {
				Window.alert("Erreur chargement :"+caught);
				
			}

			@Override
			public void onSuccess(List<Livre> result) {
				Window.alert(result.toString());
				
			}
		});
	}





	@UiHandler("button")
	void onButtonClick(ClickEvent event) {
		StatisticService.Util.getInstance().getStatistics(1, new AsyncCallback<Statistics>() {
			
			@Override
			public void onSuccess(Statistics result) {
				Window.alert(result.getClientapp());
				
			}
			
			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
				
			}
		});
	}
}
