package com.durasoft.client.ui;

import java.util.ArrayList;
import java.util.List;

import com.durasoft.client.model.Country;
import com.durasoft.client.model.CountryProperties;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiFactory;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.Widget;
import com.sencha.gxt.data.shared.ListStore;
import com.sencha.gxt.widget.core.client.grid.ColumnConfig;
import com.sencha.gxt.widget.core.client.grid.ColumnModel;
import com.sencha.gxt.widget.core.client.grid.Grid;
import com.sencha.gxt.widget.core.client.grid.GridView;

public class CountryGridExample implements IsWidget{

	@UiField
	Grid<Country> countryGrid;
	@UiField
	GridView<Country> countryGridView;
	@UiField
	ColumnModel<Country> countryColumnModel;
	@UiField
	ListStore<Country> countryStore;
	
	@UiFactory
	ColumnModel<Country> createCountryColumnModel(){
		return countryColumnModel;
	}
	
	@UiFactory
	ListStore<Country> createListStore(){
		return countryStore;
	}
	
	private static CountryGridExampleUiBinder uiBinder = GWT
			.create(CountryGridExampleUiBinder.class);

	interface CountryGridExampleUiBinder extends
			UiBinder<Widget, CountryGridExample> {
	}

	private CountryProperties countryProps = GWT.create(CountryProperties.class);

	private void initializeColumnModel(){
		ColumnConfig<Country, String> nameCol = new ColumnConfig<Country, String>(countryProps.name(),100,"Name");
		ColumnConfig<Country, String> capitalCol = new ColumnConfig<Country, String>(countryProps.capital(),100,"Capital");
		ColumnConfig<Country, String> continentCol = new ColumnConfig<Country, String>(countryProps.continent(),100,"Continent");
		List<ColumnConfig<Country, ?>> columnsList = new ArrayList<ColumnConfig<Country,?>>();
		columnsList.add(nameCol);
		columnsList.add(capitalCol);
		columnsList.add(continentCol);
		countryColumnModel = new ColumnModel<Country>(columnsList);
	}
	private ListStore<Country> getCountryStore(){
		ListStore<Country> countryStore = new ListStore<Country>(countryProps.key());
		countryStore.add(new Country("India", "New Delhi","Asia"));
		countryStore.add(new Country("USA", "Washington, D.C","North America"));
		countryStore.add(new Country("UK", "London","Europe"));
		return countryStore;
	}
	@Override
	public Widget asWidget() {
		initializeColumnModel();
		countryStore = getCountryStore();
		Widget component = uiBinder.createAndBindUi(this);
		return component;
	}
	
}
