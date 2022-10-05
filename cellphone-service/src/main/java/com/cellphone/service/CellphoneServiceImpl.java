package com.cellphone.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cellphone.model.Cellphone;
import com.cellphone.repository.CellphoneRepository;

@Service
public class CellphoneServiceImpl implements CellphoneService{

	@Autowired
	private CellphoneRepository cellphoneRepository;
	
	public List<Cellphone> getAll(){
		return cellphoneRepository.findAll();
	}
	
	public Cellphone getCellphoneById(int id) {
		return cellphoneRepository.findById(id).orElse(null);
	}
	
	public Cellphone save(Cellphone cellphone) {
		Cellphone newCellphone = cellphoneRepository.save(cellphone);
		return newCellphone;
	}
	
	public List<Cellphone> cellphonesByUserId(int userId){
		return cellphoneRepository.findByUserId(userId);
	}
}
