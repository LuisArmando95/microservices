package com.laptop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.laptop.model.Laptop;
import com.laptop.service.LaptopService;

@RestController
@RequestMapping("/laptop")
public class MotorcycleController {

	@Autowired
	private LaptopService laptopService;
	
	@GetMapping
	public ResponseEntity<List<Laptop>> laptops(){
		List<Laptop> laptops = laptopService.getAll();
		if(laptops.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(laptops);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Laptop> getLaptop(@PathVariable("id") int id){
		Laptop laptop = laptopService.getLaptopById(id);
		if(laptop == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(laptop);
	}
	
	@PostMapping
	public ResponseEntity<Laptop> saveLaptop(@RequestBody Laptop laptop){
		Laptop newLaptop = laptopService.save(laptop);
		return ResponseEntity.ok(newLaptop);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Laptop>> laptopByUserIdList(@PathVariable("userId") int id){
		List<Laptop> laptops = laptopService.laptopByUserId(id);
		if(laptops.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(laptops);
	}
	
}
