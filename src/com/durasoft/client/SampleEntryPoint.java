package com.durasoft.client;

import com.durasoft.client.ui.CountryGridExample;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class SampleEntryPoint implements EntryPoint {

	@Override
	public void onModuleLoad() {
		CountryGridExample example = new CountryGridExample();
		RootPanel.get().add(example);
	}
}
