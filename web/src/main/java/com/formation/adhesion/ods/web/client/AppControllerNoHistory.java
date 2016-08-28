package com.formation.adhesion.ods.web.client;

import com.formation.adhesion.ods.core.model.Livre;
import com.formation.adhesion.ods.web.client.event.LivreDeleteEvent;
import com.formation.adhesion.ods.web.client.event.LivreEditEvent;
import com.formation.adhesion.ods.web.client.event.LivreListEvent;
import com.formation.adhesion.ods.web.client.panel.DesktopManager;
import com.formation.adhesion.ods.web.client.presenter.LivreEditPresenter;
import com.formation.adhesion.ods.web.client.presenter.LivreListPresenter;
import com.formation.adhesion.ods.web.client.presenter.Presenter;
import com.formation.adhesion.ods.web.client.util.AbstractStep;
import com.formation.adhesion.ods.web.client.util.HistoryManager;
import com.formation.adhesion.ods.web.client.view.LivreEditViewImpl;
import com.formation.adhesion.ods.web.client.view.LivreListViewImpl;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.user.client.ui.HasWidgets;

public class AppControllerNoHistory {
	private final HandlerManager eventBus;;
	private HasWidgets container;

	public AppControllerNoHistory(HandlerManager eventBus) {
		this.eventBus = eventBus;
		bind();
	}

	private void bind() {
		// History.addValueChangeHandler(this);

		eventBus.addHandler(LivreListEvent.TYPE, new LivreListEvent.Handler() {

			@Override
			public void onSelectionChange(LivreListEvent event) {
				doLivreList();

			}
		});
		eventBus.addHandler(LivreEditEvent.TYPE, new LivreEditEvent.Handler() {

			@Override
			public void onSelectionChange(LivreEditEvent event) {
				doLivreEdit(event.getLivre());

			}
		});
		eventBus.addHandler(LivreDeleteEvent.TYPE,
				new LivreDeleteEvent.Handler() {

					@Override
					public void onSelectionChange(LivreDeleteEvent event) {
						deleteLivre(event.getLivre());

					}
				});

	}

	protected void deleteLivre(Livre l) {
		System.out.println("Un livre a ete supprime le : " + l);

	}

	private void doLivreList() {

		Presenter presenter = new LivreListPresenter(eventBus,
				new LivreListViewImpl());
		DesktopManager.getInstance().setMainContent(presenter.go());

	}

	private void doLivreEdit(final Livre livre) {
		Presenter presenter = new LivreEditPresenter(eventBus,
				new LivreEditViewImpl(), livre);
		DesktopManager.getInstance().setMainContent(presenter.go());

	}

}
