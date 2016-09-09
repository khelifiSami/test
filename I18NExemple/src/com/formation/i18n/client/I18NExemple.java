package com.formation.i18n.client;

import java.util.Date;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.i18n.client.Messages;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class I18NExemple implements EntryPoint {

	private BiblioServiceAsync biblioService = GWT.create(BiblioService.class);
	FlexTable table;
	private TraductionConstants constants = GWT.create(TraductionConstants.class);
	private TraductionMessages messages = GWT.create(TraductionMessages.class);
	
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		RootPanel root = RootPanel.get("main-div");
		VerticalPanel vp = new VerticalPanel();
		final Button lancerServiceButton = new Button("Lancer la recherche");
		lancerServiceButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				appelService();
				Window.alert( messages.message1("Bernard"));
				Window.alert( messages.today(new Date()));
				
			}
		});
		table =  new FlexTable();
		table.setBorderWidth(1);
		table.setWidget(0, 0, new Label(constants.number()));
		table.setWidget(0, 1, new Label(constants.author()));
		table.setWidget(0, 2, new Label(constants.title()));
		table.setWidget(0, 3, new Label(constants.edition()));


		vp.add(lancerServiceButton);
		vp.add(table);
		
		root.add(vp,0,0);
		
//		
		
		
		
	}
	public void onModuleLoadDynamique() {
		RootPanel root = RootPanel.get("main-div");
		
		Dictionary dico = Dictionary.getDictionary("monDico");
		
		VerticalPanel vp = new VerticalPanel();
		final Button lancerServiceButton = new Button("Lancer la recherche");
		lancerServiceButton.addClickHandler(new ClickHandler() {
			
			@Override
			public void onClick(ClickEvent event) {
				appelService();
				
				
			}
		});
		table =  new FlexTable();
		table.setBorderWidth(1);
		table.setWidget(0, 0, new Label(dico.get("number")));
		table.setWidget(0, 1, new Label(dico.get("author")));
		table.setWidget(0, 2, new Label(dico.get("title")));
		table.setWidget(0, 3, new Label(dico.get("edition")));


		vp.add(lancerServiceButton);
		vp.add(table);
		
		root.add(vp,0,0);
	
	}
	protected void appelService() {
		biblioService.getLivres(new AsyncCallback<Livre[]>() {

			@Override
			public void onFailure(Throwable caught) {
				caught.printStackTrace();
				GWT.log("Erreur sur getLivres", caught);
			}

			@Override
			public void onSuccess(Livre[] result) {
				for (int i = 0; i < result.length; i++) {
					table.setWidget(i+1, 0, new Label(String.valueOf(result[i].getNumero())));
					table.setWidget(i+1, 1, new Label(result[i].getTitre()));
					table.setWidget(i+1, 2, new Label(result[i].getAuteur()));
					table.setWidget(i+1, 3, new Label(result[i].getEditeur()));
				}
				
			}
			
		});
		
	}
}
