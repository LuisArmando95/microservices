package com.motorcycle.service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.motorcycle.service.model.Motorcycle;
import com.motorcycle.service.repository.MotorcycleRepository;

@Service
public class MotorcycleServiceImpl implements MotorcycleService{

	@Autowired
	private MotorcycleRepository motoRepository;

	public List<Motorcycle> getAll() {
		return motoRepository.findAll();
	}

	public Motorcycle getMotoById(int id) {
		return motoRepository.findById(id).orElse(null);
	}

	public Motorcycle save(Motorcycle moto) {
		Motorcycle newMoto = motoRepository.save(moto);
		return newMoto;
	}

	public List<Motorcycle> motorcycleByUserId(int userId) {
		return motoRepository.findByUserId(userId);
	}
}
