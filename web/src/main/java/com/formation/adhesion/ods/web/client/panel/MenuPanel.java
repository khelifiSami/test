package com.formation.adhesion.ods.web.client.panel;

import com.formation.adhesion.ods.web.client.event.LivreListEvent;
import com.formation.adhesion.ods.web.shared.service.DataLoaderService;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class MenuPanel extends Composite{

	private static MenuPanelUiBinder uiBinder = GWT
			.create(MenuPanelUiBinder.class);
	@UiField Button livreMenuItem;
	@UiField Button TestItem;
	 private final HandlerManager eventBus;
	 ;
	interface MenuPanelUiBinder extends UiBinder<Widget, MenuPanel> {
	}


	
	public MenuPanel(HandlerManager eventBus) {
		initWidget(uiBinder.createAndBindUi(this));
		this.eventBus = eventBus;
		
	}


 
	@UiHandler("livreMenuItem")
	void onStatisticMenuItemClick(ClickEvent event) {
		 eventBus.fireEvent(new LivreListEvent());
	} 

	@UiHandler("TestItem")
	void onTestItemClick(ClickEvent event) {
		DesktopManager.getInstance().setMainContent(new TestPanel());

	}
}
