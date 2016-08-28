package com.formation.adhesion.ods.web.client.presenter;

import java.util.List;

import com.formation.adhesion.ods.core.model.Livre;
import com.formation.adhesion.ods.web.client.event.LivreDeleteEvent;
import com.formation.adhesion.ods.web.client.event.LivreEditEvent;
import com.formation.adhesion.ods.web.client.view.LivreEditViewImpl;
import com.formation.adhesion.ods.web.client.view.LivreListView;
import com.formation.adhesion.ods.web.client.view.LivreListViewImpl;
import com.formation.adhesion.ods.web.shared.service.LivreService;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HasWidgets;
import com.google.gwt.user.client.ui.Widget;

public class LivreListPresenter implements LivreListView.Presenter {

	private HandlerManager eventBus;
	private LivreListView view;

	public LivreListPresenter(HandlerManager eventBus, LivreListView view) {
		this.eventBus = eventBus;
		this.view = view;
		// on accroche la vue a son presenter
		this.view.setPresenter(this);

	}

	@Override
	public void onDeleteButtonClicked() {
		LivreService.Util.getInstance().deleteLivre(
				view.getSelectedLivre().getId(), new AsyncCallback<Void>() {

					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
						caught.printStackTrace();
					}

					@Override
					public void onSuccess(Void result) {
						Window.alert("Livre : " + view.getSelectedLivre()
								+ " supprimé");
						chargeLivreList();
						eventBus.fireEvent(new LivreDeleteEvent(view.getSelectedLivre()));
					}
				});

		
	}

	@Override
	public Widget go() {
		chargeLivreList();
		return view.asWidget();

	}

	private void chargeLivreList() {
		LivreService.Util.getInstance().getLivres(
				new AsyncCallback<List<Livre>>() {

					@Override
					public void onSuccess(List<Livre> result) {
						view.setData(result);

					}

					@Override
					public void onFailure(Throwable caught) {
						Window.alert(caught.getMessage());
						caught.printStackTrace();
					}
				});

	}

	@Override
	public void onModifyButtonClicked() {
		if (view.getSelectedLivre() != null) {
			eventBus.fireEvent(new LivreEditEvent(view.getSelectedLivre()));
		}
	}

}
