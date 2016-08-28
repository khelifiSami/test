package com.formation.adhesion.ods.web.client.presenter;

import java.util.List;

import com.formation.adhesion.ods.core.model.Livre;
import com.formation.adhesion.ods.web.client.event.LivreDeleteEvent;
import com.formation.adhesion.ods.web.client.event.LivreListEvent;
import com.formation.adhesion.ods.web.client.view.LivreEditView;
import com.formation.adhesion.ods.web.client.view.LivreEditViewImpl;
import com.formation.adhesion.ods.web.shared.service.LivreService;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Widget;

public class LivreEditPresenter implements LivreEditView.Presenter {
	
	private HandlerManager eventBus;
	private LivreEditView view;
	

	 public LivreEditPresenter(HandlerManager eventBus, LivreEditView view, Livre livre) {
		 this.eventBus = eventBus;
		 this.view = view; 
		 view.setLivre(livre);
		 // on accroche la vue a son presenter
		 this.view.setPresenter(this);
		 
	 }

	@Override
	public Widget go() {
	    return view.asWidget();
		
	}

	@Override
	public void onLivreChange() {
		LivreService.Util.getInstance().updateLivre(
				view.getLivre(), new AsyncCallback<Void>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
						caught.printStackTrace();
					}

					@Override
					public void onSuccess(Void result) {
						Window.alert("Livre mis à jour");
						eventBus.fireEvent(new LivreListEvent());
					}
				});

		
		
	}

	@Override
	public void onLivreChanceCancel() {
		eventBus.fireEvent(new LivreListEvent());
		
	}

	

}
