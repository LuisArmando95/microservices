package com.laptop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptop.model.Laptop;
import com.laptop.repository.LaptopRepository;

@Service
public class LaptopServiceImpl implements LaptopService{

	@Autowired
	private LaptopRepository laptopRepository;

	public List<Laptop> getAll() {
		return laptopRepository.findAll();
	}

	public Laptop getLaptopById(int id) {
		return laptopRepository.findById(id).orElse(null);
	}

	public Laptop save(Laptop laptop) {
		Laptop newLaptop= laptopRepository.save(laptop);
		return newLaptop;
	}

	public List<Laptop> laptopByUserId(int userId) {
		return laptopRepository.findByUserId(userId);
	}
}
