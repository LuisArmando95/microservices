package com.motorcycle.service.service;

import java.util.List;

import com.motorcycle.service.model.Motorcycle;

public interface MotorcycleService {
	
	public List<Motorcycle> getAll();
	

	public Motorcycle getMotoById(int id);
	

	public Motorcycle save(Motorcycle moto);
	

	public List<Motorcycle> motorcycleByUserId(int userId);
	

}
