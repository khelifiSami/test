package com.formation.celltable.client;

import java.util.Arrays;
import java.util.List;

import com.formation.celltable.client.MyCellTable.Binder;
import com.formation.celltable.client.datagrid.MyDataGridCamion;
import com.formation.celltable.client.image.MyImageBunleCamion;
import com.google.gwt.cell.client.EditTextCell;
import com.google.gwt.cell.client.ImageResourceCell;
import com.google.gwt.cell.client.Cell.Context;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.view.client.ListDataProvider;

public class MyCellTabaleCamion extends Composite  {


	@UiField
	CellTable<MarqueCamion> dataGridMarquecamion;

	private static final Binder binder = GWT.create(Binder.class);

	interface Binder extends UiBinder<Widget, MyCellTabaleCamion> {
	}

	public MyCellTabaleCamion() {
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
	}
		

}
