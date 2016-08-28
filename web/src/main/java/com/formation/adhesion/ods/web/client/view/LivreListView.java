package com.formation.adhesion.ods.web.client.view;

import java.util.List;

import com.formation.adhesion.ods.core.model.Livre;
import com.google.gwt.user.client.ui.Widget;

public interface LivreListView  {
	public interface Presenter extends com.formation.adhesion.ods.web.client.presenter.Presenter {
		void onDeleteButtonClicked();
		void onModifyButtonClicked();
	}

	void setData(List<Livre> livres);
	Widget asWidget();
	void setPresenter(LivreListView.Presenter presenter);
	Livre getSelectedLivre();
}
