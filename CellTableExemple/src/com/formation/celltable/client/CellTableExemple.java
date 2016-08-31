package com.formation.celltable.client;

//import com.formation.celltable.client.datagrid.MyDataGrid;
import com.formation.celltable.client.datagrid.MyDataGridCamion;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class CellTableExemple implements EntryPoint {

	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get("monModule");
		
//		MyCellTable cellTable = new MyCellTable();
//		rootPanel.get("monModule").add(cellTable);
		
		MyDataGridCamion dataGridCamion = new MyDataGridCamion();
		rootPanel.get("monModule").add(dataGridCamion);
		
//		cellTable.setSize("100%", "100%");
		
	}
}
