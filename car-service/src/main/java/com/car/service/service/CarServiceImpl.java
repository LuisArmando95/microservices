package com.car.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.car.service.model.Car;
import com.car.service.repository.CarRepository;

@Service
public class CarServiceImpl implements CarService{

	@Autowired
	private CarRepository carRepository;
	
	public List<Car> getAll(){
		return carRepository.findAll();
	}
	
	public Car getCarById(int id) {
		return carRepository.findById(id).orElse(null);
	}
	
	public Car save(Car carro) {
		Car nuevoCarro = carRepository.save(carro);
		return nuevoCarro;
	}
	
	public List<Car> carsByUserId(int usuarioId){
		return carRepository.findByUserId(usuarioId);
	}
}
