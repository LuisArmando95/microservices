package com.motorcycle.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.motorcycle.service.model.Motorcycle;
import com.motorcycle.service.service.MotorcycleService;

@RestController
@RequestMapping("/moto")
public class MotorcycleController {

	@Autowired
	private MotorcycleService motoService;
	
	@GetMapping
	public ResponseEntity<List<Motorcycle>> motorcycles(){
		List<Motorcycle> motorcycles = motoService.getAll();
		if(motorcycles.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(motorcycles);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Motorcycle> getMotorcycle(@PathVariable("id") int id){
		Motorcycle moto = motoService.getMotoById(id);
		if(moto == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(moto);
	}
	
	@PostMapping
	public ResponseEntity<Motorcycle> saveMotorcycle(@RequestBody Motorcycle moto){
		Motorcycle newMotrocycle = motoService.save(moto);
		return ResponseEntity.ok(newMotrocycle);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Motorcycle>> motorcycleByUserIdList(@PathVariable("userId") int id){
		List<Motorcycle> motorcycles = motoService.motorcycleByUserId(id);
		if(motorcycles.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(motorcycles);
	}
	
}
