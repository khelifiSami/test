package com.formation.celltable.client;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import com.formation.celltable.client.image.MyImageBundle;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.FieldUpdater;
import com.google.gwt.cell.client.ImageResourceCell;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.cell.client.TextCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

public class MyCellTable extends Composite {

	private static final Binder binder = GWT.create(Binder.class);
	@UiField
	CellTable<MarqueVoiture> tableMarqueVoiture;

	interface Binder extends UiBinder<Widget, MyCellTable> {
	}

	public MyCellTable() {
		initWidget(binder.createAndBindUi(this));
		initCellTable();
		
	}

	private void initCellTable() {

		Column<MarqueVoiture, ImageResource> logo = new Column<MarqueVoiture, ImageResource>(
				new ImageResourceCell()) {

			@Override
			public ImageResource getValue(MarqueVoiture marque) {
				if (marque.getNom().equalsIgnoreCase("ford"))
					return MyImageBundle.INSTANCE.ford();
				if (marque.getNom().equalsIgnoreCase("bmw"))
					return MyImageBundle.INSTANCE.bmw();
				if (marque.getNom().equalsIgnoreCase("citroen"))
					return MyImageBundle.INSTANCE.citroen();
				if (marque.getNom().equalsIgnoreCase("honda"))
					return MyImageBundle.INSTANCE.honda();
				return MyImageBundle.INSTANCE.ford();
			}

		};
		tableMarqueVoiture.addColumn(logo, "");
		final EditTextCell edtNom = new EditTextCell();
		final Column<MarqueVoiture, String> nom = new Column<MarqueVoiture, String>(
				edtNom) {
			@Override
			public String getValue(MarqueVoiture object) {
				return object.getNom();
			}
			@Override
					public void render(Context context, MarqueVoiture object,
							SafeHtmlBuilder sb) {

						sb.appendHtmlConstant("<strong>");
						super.render(context, object, sb);
						sb.appendHtmlConstant("</strong>");
					}
		};
		nom.setFieldUpdater(new FieldUpdater<MarqueVoiture, String>() {
			public void update(int index, MarqueVoiture object, String value) {
				// Validate the data.
				if (value.length() < 3) {
					Window.alert("Names must be at least three characters long.");

					/*
					 * Clear the view data. The view data contains the pending
					 * change and allows the table to render with the pending
					 * value until the data is committed. If the data is
					 * committed into the object, the view data is automatically
					 * cleared out. If the data is not committed because it is
					 * invalid, you must delete.
					 */
					edtNom.clearViewData(object);

					// Redraw the table.
					tableMarqueVoiture.redraw();
					return;
				}
				object.setNom(value);
			}
		});

		tableMarqueVoiture.addColumn(nom, "Nom");

		Column<MarqueVoiture, String> pays = new Column<MarqueVoiture, String>(
				new TextCell()) {
			@Override
			public String getValue(MarqueVoiture object) {
				return object.getPays();
			}

		};
		tableMarqueVoiture.addColumn(pays, "Pays");

		Column<MarqueVoiture, Number> anneeCreation = new Column<MarqueVoiture, Number>(
				new NumberCell(NumberFormat.getFormat("####"))) {
			@Override
			public Number getValue(MarqueVoiture object) {

				return object.getAnneeCreation();
			}
		};
		tableMarqueVoiture.addColumn(anneeCreation, "Année");
		
		tableMarqueVoiture.addColumnStyleName(2, "pays");

		// preparation du dataProvider
		List<MarqueVoiture> voitures = 
				Arrays.asList(MarqueVoitureData.extract());
		ListDataProvider<MarqueVoiture> dataProvider = 
					new ListDataProvider<MarqueVoiture>();
		dataProvider.setList(voitures);
		
		// envoie les données dans la cellTable
		dataProvider.addDataDisplay(tableMarqueVoiture);
		
		
		
	    ListHandler<MarqueVoiture> sortHandler = 
	    	new ListHandler<MarqueVoiture>(dataProvider.getList());
	    nom.setSortable(true);
	    tableMarqueVoiture.addColumnSortHandler(sortHandler);
	    sortHandler.setComparator(nom, new Comparator<MarqueVoiture>() {
	        public int compare(MarqueVoiture o1, MarqueVoiture o2) {
	          return o1.getNom().compareTo(o2.getNom());
	        }
	      });
	    
	    // tri de depart sur la colonne nom
	    tableMarqueVoiture.getColumnSortList().push(nom);
	

		
	}

}
