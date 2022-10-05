package com.cellphone.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cellphone.model.Cellphone;
import com.cellphone.service.CellphoneService;

@RestController
@RequestMapping("/cellphone")

public class CellphoneController {

	@Autowired
	private CellphoneService cellphoneService;
	
	@GetMapping
	public ResponseEntity<List<Cellphone>> cellphonesList(){
		List<Cellphone> cellphones = cellphoneService.getAll();
		if(cellphones.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cellphones);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Cellphone> getCellphone(@PathVariable("id") int id){
		Cellphone cellphone = cellphoneService.getCellphoneById(id);
		if(cellphone == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(cellphone);
	}
	
	@PostMapping
	public ResponseEntity<Cellphone> saveCellphone(@RequestBody Cellphone cellphone){
		Cellphone newCellphone = cellphoneService.save(cellphone);
		return ResponseEntity.ok(newCellphone);
	}
	
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Cellphone>> getCellphonesByUserIdList(@PathVariable("userId") int id){
		List<Cellphone> cellphones = cellphoneService.cellphonesByUserId(id);
		if(cellphones.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(cellphones);
	}
}