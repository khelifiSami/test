package com.formation.adhesion.ods.web.client.view;

import java.util.List;

import com.formation.adhesion.ods.core.model.Livre;
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
import com.google.gwt.view.client.ProvidesKey;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.gwt.user.client.ui.Button;

public class LivreListViewImpl extends Composite implements LivreListView {

	private static LivreListViewImplUiBinder uiBinder = GWT
			.create(LivreListViewImplUiBinder.class);

	interface LivreListViewImplUiBinder extends
			UiBinder<Widget, LivreListViewImpl> {
	}

	@UiField(provided = true)
	SimplePager pager;
	@UiField(provided = true)
	CellTable<Livre> cellTable;
	@UiField Button modifyButton;

	private Presenter presenter;

	public Presenter getPresenter() {
		return presenter;
	}

	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}

	public LivreListViewImpl() {
		buidCellTable();

		buildSimplePager();

		initWidget(uiBinder.createAndBindUi(this));

	}

	private void buildSimplePager() {
		// Create a Pager to control the table.
		SimplePager.Resources pagerResources = GWT
				.create(SimplePager.Resources.class);
		pager = new SimplePager(TextLocation.CENTER, pagerResources, false, 0,
				true);
		pager.setDisplay(cellTable);

	}

	private void buidCellTable() {
		cellTable = new CellTable<Livre>();
		SingleSelectionModel<Livre> selectionModel = new SingleSelectionModel<Livre>();
		ProvidesKey<Livre> keyProvider = new ProvidesKey<Livre>() {
			public Object getKey(Livre item) {
				// Always do a null check.
				return (item == null) ? null : item.getId();
			}
		};
		cellTable.setSelectionModel(selectionModel);
		Column<Livre, Number> idColumn = new Column<Livre, Number>(
				new NumberCell()) {
			@Override
			public Long getValue(Livre object) {
				return object.getId();
			}
		};
		cellTable.addColumn(idColumn, "Id");

		Column<Livre, String> titreColumn = new Column<Livre, String>(
				new TextCell()) {
			@Override
			public String getValue(Livre object) {
				return object.getTitre();
			}
		};
		cellTable.addColumn(titreColumn, "titre");
		cellTable.setPageSize(20);

	}

	@UiHandler("deleteButton")
	public void onDeleteButtonEvent(ClickEvent ce) {
		presenter.onDeleteButtonClicked();
	}

	public Widget asWidget() {
		return this;
	}

	@Override
	public void setData(List<Livre> livres) {
		cellTable.setRowData(livres);
	}

	@Override
	public Livre getSelectedLivre() {
		SingleSelectionModel<Livre> ssm = (SingleSelectionModel<Livre>) cellTable.getSelectionModel();		
		return ssm.getSelectedObject();
	}

	@UiHandler("modifyButton")
	void onModifyButtonClick(ClickEvent event) {
		presenter.onModifyButtonClicked();
	}
}
