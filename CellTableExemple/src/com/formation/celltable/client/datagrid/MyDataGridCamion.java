package com.formation.celltable.client.datagrid;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.formation.celltable.client.MarqueCamion;
import com.formation.celltable.client.MarqueCamionData;
import com.formation.celltable.client.MarqueVoiture;
import com.formation.celltable.client.datagrid.MyDataGrid.Binder;
import com.formation.celltable.client.image.MyImageBunleCamion;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.ImageResourceCell;
import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.ColumnSortEvent.ListHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;


public class MyDataGridCamion extends Composite  {
		
	@UiField
	DataGrid<MarqueCamion> dataGridMarquecamion;
	private static  final Binder binder = GWT.create(Binder.class);
	interface Binder extends UiBinder<Widget, MyDataGridCamion> {
	}

	public MyDataGridCamion() {
		initWidget(binder.createAndBindUi(this));
		initeTabale();
	}

	public void initeTabale(){
		Column<MarqueCamion, ImageResource> logo = new Column<MarqueCamion, ImageResource>(
				new ImageResourceCell()) {

			@Override
			public ImageResource getValue(MarqueCamion marque) {
				if (marque.getMarque().equalsIgnoreCase("alfaromeo"))
					return MyImageBunleCamion.INSTANCE_CAMION.alfaromeo();
				if (marque.getMarque().equalsIgnoreCase("citroen"))
					return MyImageBunleCamion.INSTANCE_CAMION.citroen();
				if (marque.getMarque().equalsIgnoreCase("france"))
					return MyImageBunleCamion.INSTANCE_CAMION.france();
				if (marque.getMarque().equalsIgnoreCase("toyota"))
					return MyImageBunleCamion.INSTANCE_CAMION.toyota();
				return MyImageBunleCamion.INSTANCE_CAMION.alfaromeo();
			}	
		

		};
		dataGridMarquecamion.addColumn(logo,"image");
		final EditTextCell edt 					= new EditTextCell();
		Column<MarqueCamion, String> couleur 	= new Column<MarqueCamion, String>(edt) {

			@Override
			public String getValue(MarqueCamion coleur) {
				
				return coleur.getCouleur();
			}
			@Override
			public void render(Context context, MarqueCamion coleur,
					SafeHtmlBuilder sb) {
				sb.appendHtmlConstant("<strong>");
				super.render(context, coleur, sb);
				sb.appendHtmlConstant("</strong>");
			}
		};
		dataGridMarquecamion.addColumn(couleur,"couleur");
		List<MarqueCamion> camions 					= 	Arrays.asList(MarqueCamionData.data());
		ListDataProvider<MarqueCamion> camionsData	= 	 new ListDataProvider<MarqueCamion>();		
		camionsData.setList(camions);
		// envoie les données dans la cellTable
		camionsData.addDataDisplay(dataGridMarquecamion);
		ListHandler<MarqueCamion> sortHandler = new ListHandler<MarqueCamion>(camionsData.getList());
		couleur.setSortable(true);
		dataGridMarquecamion.addColumnSortHandler(sortHandler);

		sortHandler.setComparator(couleur, new Comparator<MarqueCamion>() {
			public int compare(MarqueCamion o1, MarqueCamion o2) {
				return o1.getCouleur().compareTo(o2.getCouleur());
			}
						
		});
	}
		
}
