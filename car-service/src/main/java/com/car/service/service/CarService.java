package com.car.service.service;

import java.util.List;

import com.car.service.model.Car;

public interface CarService {
	
	public List<Car> getAll();
	
	
	public Car getCarById(int id);
	
	
	public Car save(Car carro);
	
	
	public List<Car> carsByUserId(int usuarioId);
	

}
