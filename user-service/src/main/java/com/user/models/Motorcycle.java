package com.user.models;


public class Motorcycle {


	private String brand;
	
	private String model;
	
	private int userId;


	public String getBrand() {
		return brand;
	}



	public void setBrand(String brand) {
		this.brand = brand;
	}



	public String getModel() {
		return model;
	}



	public void setModel(String model) {
		this.model = model;
	}
	
	public int getUserId() {
		return userId;
	}



	public void setUserId(int userId) {
		this.userId = userId;
	}



	public Motorcycle() {
		super();
	}
}
