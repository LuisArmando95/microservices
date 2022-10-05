package com.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.feignClients.CarFeignClient;
import com.user.feignClients.MotorcycleFeignClient;
import com.user.models.Car;
import com.user.models.Motorcycle;
import com.user.models.User;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CarFeignClient carFeignClient;

	@Autowired
	private MotorcycleFeignClient motorcycleFeignClient;

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	public User save(User user) {
		User newUser = userRepository.save(user);
		return newUser;
	}

	
	public List<Car> getCars(int userId) { 
		List<Car> cars = restTemplate.getForObject("http://localhost:8091/car/user/" + userId, List.class); 
	  	return cars; 
	}
	  
	public List<Motorcycle> getMotorcycles(int userId) { 
		List<Motorcycle> motorcycles = restTemplate.getForObject("http://localhost:8092/moto/user/" + userId, List.class); 
		return motorcycles; 
	}
	
	public Car saveCar(int userId, Car car) {
		car.setUserId(userId);
		Car newCar = carFeignClient.save(car);
		return newCar;
	}
	
	public Motorcycle saveMotorcycle(int userId, Motorcycle motorcycle) {
		motorcycle.setUserId(userId);
		Motorcycle newMotorcycle = motorcycleFeignClient.save(motorcycle);
		return newMotorcycle;
	}
	
	public Map<String, Object> getUsersAndVehicles (int userId) {
		Map<String,Object> result = new HashMap<>();
		User user = userRepository.findById(userId).orElse(null);
		
		if(user == null) {
			result.put("Message", "El usuario no existe");
			return result;
		}
		
		result.put("User",user);
		List<Car> cars = carFeignClient.getCars(userId);
		if(cars == null) {
			result.put("Cars", "The user dont have a car.");
		} else {
			if(cars.isEmpty()) {
				result.put("Cars", "The user dont have a car.");
			}
			else {
				result.put("Cars", cars);
			}
		}
		
		List<Motorcycle> motorcycles = motorcycleFeignClient.getMotos(userId);
		if(motorcycles == null) {
			result.put("Motorcycles", "The user dont have a motorcycle.");
		} else {
			if(motorcycles.isEmpty()) {
				result.put("Motorcycles", "The user dont have a motorcycle.");
			}		
			else {
				result.put("Motorcycles", motorcycles);
			}
		}
	
		return result;
	}


}