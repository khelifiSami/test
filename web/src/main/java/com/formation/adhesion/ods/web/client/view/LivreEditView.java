package com.formation.adhesion.ods.web.client.view;

import java.util.List;

import com.formation.adhesion.ods.core.model.Livre;
import com.formation.adhesion.ods.web.client.presenter.LivreListPresenter;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.cellview.client.SimplePager.TextLocation;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public interface LivreEditView  {
	public interface Presenter extends com.formation.adhesion.ods.web.client.presenter.Presenter {
		void onLivreChange();
		void onLivreChanceCancel();
	}
	void setPresenter(LivreEditView.Presenter presenter);

	void setLivre(Livre livre);
	Livre getLivre();
	Widget asWidget();
}
