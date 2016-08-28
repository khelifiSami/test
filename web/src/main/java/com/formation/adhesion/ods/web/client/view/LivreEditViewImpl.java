package com.formation.adhesion.ods.web.client.view;

import com.formation.adhesion.ods.core.model.Livre;
import com.formation.adhesion.ods.web.client.view.LivreListView.Presenter;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.LongBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class LivreEditViewImpl extends Composite implements LivreEditView {


	private static LivreEditViewImplUiBinder uiBinder = GWT
			.create(LivreEditViewImplUiBinder.class);
	@UiField Button okButton;
	@UiField Button cancelButton;
	@UiField LongBox idField;
	@UiField TextBox titreField;
	private Livre livre;
	
	private Presenter presenter;
	
	interface LivreEditViewImplUiBinder extends
			UiBinder<Widget, LivreEditViewImpl> {
	}

	public LivreEditViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	@UiHandler("okButton")
	void onOkButtonClick(ClickEvent event) {
		livre.setId(idField.getValue());
		livre.setTitre(titreField.getValue());
		presenter.onLivreChange();
	}
	@UiHandler("cancelButton")
	void onCancelButtonClick(ClickEvent event) {
		presenter.onLivreChanceCancel();
	}

	@Override
	public void setLivre(Livre livre) {
		this.livre = livre;
		idField.setValue(livre.getId());
		titreField.setValue(livre.getTitre());
		
	}

	@Override
	public Livre getLivre() {
		return livre;
	}

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
		
	}
	@Override
	public Widget asWidget() {
		return this;
	}
}
