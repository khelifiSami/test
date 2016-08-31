package com.formation.celltable.client;

import com.formation.celltable.client.datagrid.MyDataGrid;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class CellTableExemple implements EntryPoint {

	public void onModuleLoad() {
		RootPanel rootPanel = RootPanel.get("monModule");
		
//		MyCellTable cellTable = new MyCellTable();
//		rootPanel.get("monModule").add(cellTable);
		
		MyDataGrid dataGrid = new MyDataGrid();
		rootPanel.get("monModule").add(dataGrid);
		
//		cellTable.setSize("100%", "100%");
		
	}
}
