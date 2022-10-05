package com.user.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.models.Car;
import com.user.models.Motorcycle;
import com.user.models.User;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<User>> usersList(){
		List<User> users = userService.getAll();
		if(users.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(users);
	}

	@GetMapping("/{id}")
	public ResponseEntity<User> getUser(@PathVariable("id") int id){
		User user = userService.getUserById(id);
		if(user == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(user);
	}
	
	@PostMapping
	public ResponseEntity<User> saveUser(@RequestBody User user){
		User newUser = userService.save(user);
		return ResponseEntity.ok(newUser);
	}
	
	@GetMapping("/cars/{userId}")
	public ResponseEntity<List<Car>> carsList(@PathVariable("userId") int id){
		User user = userService.getUserById(id);
		if(user == null) {
			return ResponseEntity.notFound().build();
		}
		
		List<Car> cars = userService.getCars(id);
		return ResponseEntity.ok(cars);
	}
	
	@GetMapping("/motorcycles/{userId}")
	public ResponseEntity<List<Motorcycle>> motorcyclesList(@PathVariable("userId") int id){
		User user = userService.getUserById(id);
		if(user == null) {
			return ResponseEntity.notFound().build();
		}
		
		List<Motorcycle> motorcycles = userService.getMotorcycles(id);
		return ResponseEntity.ok(motorcycles);
	}
	
	@PostMapping("/car/{userId}")
	public ResponseEntity<Car> saveCar(@PathVariable("userId") int userId,@RequestBody Car car){
		Car newCar = userService.saveCar(userId, car);
		return ResponseEntity.ok(newCar);
	} 
	
	@PostMapping("/moto/{userId}")
	public ResponseEntity<Motorcycle> saveMotorcycle(@PathVariable("userId") int userId, @RequestBody Motorcycle motorcycle){
		Motorcycle newMotorcycle = userService.saveMotorcycle(userId, motorcycle);
		return ResponseEntity.ok(newMotorcycle);
	}
	
	@GetMapping("/everything/{userId}")
	public ResponseEntity<Map<String, Object>> everyVehiclesByUserList(@PathVariable("userId") int userId){
		Map<String,Object> result = userService.getUsersAndVehicles(userId);
		return ResponseEntity.ok(result);
	}
	
	
}