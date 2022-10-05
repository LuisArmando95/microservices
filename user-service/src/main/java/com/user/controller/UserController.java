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

import com.user.models.Cellphone;
import com.user.models.Laptop;
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
	
	@GetMapping("/cellphones/{userId}")
	public ResponseEntity<List<Cellphone>> cellphonesList(@PathVariable("userId") int id){
		User user = userService.getUserById(id);
		if(user == null) {
			return ResponseEntity.notFound().build();
		}
		
		List<Cellphone> cellphones = userService.getCellphones(id);
		return ResponseEntity.ok(cellphones);
	}
	
	@GetMapping("/laptops/{userId}")
	public ResponseEntity<List<Laptop>> laptopsList(@PathVariable("userId") int id){
		User user = userService.getUserById(id);
		if(user == null) {
			return ResponseEntity.notFound().build();
		}
		
		List<Laptop> laptops = userService.getLaptops(id);
		return ResponseEntity.ok(laptops);
	}
	
	@PostMapping("/cellphone/{userId}")
	public ResponseEntity<Cellphone> saveCellphone(@PathVariable("userId") int userId,@RequestBody Cellphone cellphone){
		Cellphone newCellphone = userService.saveCellphone(userId, cellphone);
		return ResponseEntity.ok(newCellphone);
	} 
	
	@PostMapping("/laptop/{userId}")
	public ResponseEntity<Laptop> saveMotorcycle(@PathVariable("userId") int userId, @RequestBody Laptop laptop){
		Laptop newLaptop = userService.saveLaptop(userId, laptop);
		return ResponseEntity.ok(newLaptop);
	}
	
	@GetMapping("/everything/{userId}")
	public ResponseEntity<Map<String, Object>> everyEquipmentByUserList(@PathVariable("userId") int userId){
		Map<String,Object> result = userService.getUsersAndEquipment(userId);
		return ResponseEntity.ok(result);
	}
	
	
}