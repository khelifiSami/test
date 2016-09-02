package com.formation.smartgwt.client;
/*
 * Smart GWT (GWT for SmartClient)
 * Copyright 2008 and beyond, Isomorphic Software, Inc.
 *
 * Smart GWT is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License version 3
 * as published by the Free Software Foundation.  Smart GWT is also
 * available under typical commercial license terms - see
 * http://smartclient.com/license
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 */

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DecoratedTabPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.smartgwt.client.data.Criteria;
import com.smartgwt.client.data.DataSource;
import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.IButton;
import com.smartgwt.client.widgets.events.ClickEvent;
import com.smartgwt.client.widgets.events.ClickHandler;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.SelectItem;
import com.smartgwt.client.widgets.form.fields.events.ChangedEvent;
import com.smartgwt.client.widgets.form.fields.events.ChangedHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.grid.events.RecordClickEvent;
import com.smartgwt.client.widgets.grid.events.RecordClickHandler;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;


public class SmartGWTExemple implements EntryPoint {


    public void onModuleLoad() {
        final DataSource countryDS = CountryXmlDS.getInstance();
        final DataSource supplyItemDS = ItemSupplyXmlDS.getInstance();

        final CompoundEditor cEditor = new CompoundEditor(countryDS);

        SelectItem dsSelect = new SelectItem();
        dsSelect.setName("datasource");
        dsSelect.setShowTitle(false);
        dsSelect.setValueMap("country", "supply");
        dsSelect.addChangedHandler(new ChangedHandler() {
            public void onChanged(ChangedEvent event) {
                String ds = (String) event.getValue();
                if (ds.equalsIgnoreCase("country")) {
                    cEditor.setDatasource(countryDS);
                } else {
                    cEditor.setDatasource(supplyItemDS);
                }
            }
        });
        DynamicForm form = new DynamicForm();
        form.setValue("datasource", "Select a DataSource");
        form.setItems(dsSelect);

        VLayout layout = new VLayout(15);
        layout.setWidth100();
        layout.setHeight("80%");

        //layout.addMember(form);
        layout.addMember(cEditor);

        DecoratedTabPanel dtp = new DecoratedTabPanel();
        dtp.setWidth("100%");
        dtp.add(form,"Liste");
        dtp.add(cEditor,"Editeur");
        dtp.add(new ExempleUIBinder(),"UiBinder");
       // layout.draw();
        
        RootPanel.get("monModule").add(dtp);
    }

    private static class CompoundEditor extends HLayout {
        private DataSource datasource;
        private DynamicForm form;
        private ListGrid grid;
        private IButton saveButton;

        private CompoundEditor(DataSource datasource) {
            this.datasource = datasource;
        }

        @Override 
        protected void onInit() {
            super.onInit();
            this.form = new DynamicForm();

            form.setDataSource(datasource);

            saveButton = new IButton("Save");
            saveButton.setLayoutAlign(Alignment.CENTER);
            saveButton.addClickHandler(new ClickHandler() {

                public void onClick(ClickEvent event) {
                    form.saveData();

                }
            });
            Button b  = new Button("Filter"); 
            b.addClickHandler(new com.google.gwt.event.dom.client.ClickHandler() {
				
				@Override
				public void onClick(com.google.gwt.event.dom.client.ClickEvent event) {
					// TODO Auto-generated method stub
                    form.getDataSource().filterData(new Criteria("continent","Europe"));
                    grid.filterData(new Criteria("continent","Europe"));
					
				}
			});

            VLayout editorLayout = new VLayout(5);
            editorLayout.addMember(form);
            editorLayout.addMember(saveButton);
            editorLayout.addMember(b);
            editorLayout.setWidth(280);

            grid = new ListGrid();
            grid.setWidth(500);
            grid.setHeight(350);
            grid.setDataSource(datasource);
            grid.setAutoFetchData(true);
            grid.addRecordClickHandler(new RecordClickHandler() {
                public void onRecordClick(RecordClickEvent event) {
                    form.clearErrors(true);
                    form.editRecord(event.getRecord());
                    saveButton.enable();
                }

            });

            addMember(grid);
            addMember(editorLayout);
        }

        public DataSource getDatasource() {
            return datasource;
        }

        public void setDatasource(DataSource datasource) {
            this.datasource = datasource;
            grid.setDataSource(datasource);
            form.setDataSource(datasource);
            saveButton.disable();
            grid.fetchData();
        }
    }



}
