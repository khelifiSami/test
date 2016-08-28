package com.formation.adhesion.ods.web.client;

import com.formation.adhesion.ods.web.client.panel.DesktopManager;
import com.formation.adhesion.ods.web.client.panel.HeaderPanel;
import com.formation.adhesion.ods.web.client.panel.MenuPanel;
import com.formation.adhesion.ods.web.client.panel.WelcomePanel;
import com.formation.adhesion.ods.web.client.resource.MainClientBundle;
import com.formation.adhesion.ods.web.client.util.AbstractStep;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.RootLayoutPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ODSWeb implements EntryPoint {

	@Override
	public void onModuleLoad() {
		MainClientBundle.INSTANCE.mainStyle().ensureInjected();
		

	    HandlerManager eventBus = new HandlerManager(this);
		AppController appViewer = new AppController(eventBus);
		DesktopManager.getInstance().setHeader( new HeaderPanel());


		RootLayoutPanel.get().add(DesktopManager.getInstance().getContainer());
		DesktopManager.getInstance().setMenu(new MenuPanel(eventBus));

		DesktopManager.getInstance().setMainContent(new WelcomePanel());
	
	
		
	}
	
	
}
