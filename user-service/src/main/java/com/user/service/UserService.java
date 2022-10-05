package com.user.service;

import java.util.List;
import java.util.Map;

import com.user.models.Car;
import com.user.models.Motorcycle;
import com.user.models.User;

public interface UserService {
	
	public List<User> getAll();

	public User getUserById(int id);

	public User save(User user);

	public List<Car> getCars(int userId); 
	  
	public List<Motorcycle> getMotorcycles(int userId); 
	
	public Car saveCar(int userId, Car car);
	
	public Motorcycle saveMotorcycle(int userId, Motorcycle motorcycle);
	
	public Map<String, Object> getUsersAndVehicles (int userId);
	

}
