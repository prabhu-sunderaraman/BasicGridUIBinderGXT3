package com.durasoft.client.model;

public class Country {
	private String name;
	private String capital;
	private String continent;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Country() {
	}
	public Country(String name, String capital, String continent) {
		this.name = name;
		this.capital = capital;
		this.continent = continent;
	}
	public String getCapital() {
		return capital;
	}
	public void setCapital(String capital) {
		this.capital = capital;
	}
	public String getContinent() {
		return continent;
	}
	public void setContinent(String continent) {
		this.continent = continent;
	}
}
