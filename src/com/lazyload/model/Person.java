package com.lazyload.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lazyloading.tag.intface.LazyLoadingModel;

public class Person extends LazyLoadingModel {
	private boolean checked;
	private String userId;
	private String personName;
	private String street;
	private String country;
	private String registeredOn;
	private String email;
	private ArrayList<String> hobbies;
	
	private String remarks;
	private String selectedHobby;
	private String address;	
	
	
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getSelectedHobby() {
		return selectedHobby;
	}

	public void setSelectedHobby(String selectedHobby) {
		this.selectedHobby = selectedHobby;
	}

	public ArrayList<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(ArrayList<String> hobbies) {
		this.hobbies = hobbies;
	}

	public boolean isChecked() {
		return checked;
	}

	public void setChecked(boolean checked) {
		this.checked = checked;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegisteredOn() {
		return registeredOn;
	}

	public void setRegisteredOn(String registeredOn) {
		this.registeredOn = registeredOn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		if(this.street == null && this.country == null)
			return this.address;
			
		return this.street + ", " + this.country;
	}

	@Override
	public List<?> lazyLoad(Long begin, Long end, HttpServletRequest request,
			HashMap<String, String> requestAttr) throws Exception {
		// EMPTY IMPLEMENTATION
		return null;
	}

	@Override
	public Long lazyLoadTotalCount(HttpServletRequest request,
			HashMap<String, String> requestAttr) throws Exception {
		// EMPTY IMPLEMENTATION
		return null;
	}
	
	
	
	
	
}
