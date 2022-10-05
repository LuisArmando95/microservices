package com.cellphone.service;

import java.util.List;

import com.cellphone.model.Cellphone;

public interface CellphoneService {
	
	public List<Cellphone> getAll();
	
	
	public Cellphone getCellphoneById(int id);
	
	
	public Cellphone save(Cellphone carro);
	
	
	public List<Cellphone> cellphonesByUserId(int usuarioId);
	

}
