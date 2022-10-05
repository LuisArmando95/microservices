package com.user.service;

import java.util.List;
import java.util.Map;

import com.user.models.Cellphone;
import com.user.models.Laptop;
import com.user.models.User;

public interface UserService {
	
	public List<User> getAll();

	public User getUserById(int id);

	public User save(User user);

	public List<Cellphone> getCellphones(int userId); 
	  
	public List<Laptop> getLaptops(int userId); 
	
	public Cellphone saveCellphone(int userId, Cellphone cellphone);
	
	public Laptop saveLaptop(int userId, Laptop laptop);
	
	public Map<String, Object> getUsersAndEquipment (int userId);
	

}
