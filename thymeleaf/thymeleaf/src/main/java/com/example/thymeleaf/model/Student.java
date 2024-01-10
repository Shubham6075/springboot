package com.example.thymeleaf.model;

import java.util.List;

public class Student {

	private String firstName;

	private String lastName;

	private String country;

	private String favouriteLanguage;

	private String languages;

	private List<String> favouriteSystems;

	// default constructor
	public Student(){

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public List<String> getFavouriteSystems() {
		return favouriteSystems;
	}

	public void setFavouriteSystems(List<String> favouriteSystems) {
		this.favouriteSystems = favouriteSystems;
	}
}
