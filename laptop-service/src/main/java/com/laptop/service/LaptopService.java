package com.laptop.service;

import java.util.List;

import com.laptop.model.Laptop;

public interface LaptopService {
	
	public List<Laptop> getAll();
	

	public Laptop getLaptopById(int id);
	

	public Laptop save(Laptop laptop);
	

	public List<Laptop>laptopByUserId(int userId);
	

}
