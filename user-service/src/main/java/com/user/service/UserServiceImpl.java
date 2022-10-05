package com.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.feignClients.CellphoneFeignClient;
import com.user.feignClients.LaptopFeignClient;
import com.user.models.Cellphone;
import com.user.models.Laptop;
import com.user.models.User;
import com.user.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CellphoneFeignClient cellphoneFeignClient;

	@Autowired
	private LaptopFeignClient laptopFeignClient;

	public List<User> getAll() {
		return userRepository.findAll();
	}

	public User getUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	public User save(User user) {
		User newUser = userRepository.save(user);
		return newUser;
	}

	
	public List<Cellphone> getCellphones(int userId) { 
		List<Cellphone> cellphones = restTemplate.getForObject("http://localhost:8091/cellphone/user/" + userId, List.class); 
	  	return cellphones; 
	}
	  
	public List<Laptop> getLaptops(int userId) { 
		List<Laptop> laptops = restTemplate.getForObject("http://localhost:8092/laptop/user/" + userId, List.class); 
		return laptops; 
	}
	
	public Cellphone saveCellphone(int userId, Cellphone cellphone) {
		cellphone.setUserId(userId);
		Cellphone newCellphone = cellphoneFeignClient.save(cellphone);
		return newCellphone;
	}
	
	public Laptop saveLaptop(int userId, Laptop laptop) {
		laptop.setUserId(userId);
		Laptop newLaptop = laptopFeignClient.save(laptop);
		return newLaptop;
	}
	
	public Map<String, Object> getUsersAndEquipment (int userId) {
		Map<String,Object> result = new HashMap<>();
		User user = userRepository.findById(userId).orElse(null);
		
		if(user == null) {
			result.put("Message", "User doesnt exist.");
			return result;
		}
		
		result.put("User",user);
		List<Cellphone> cellphones = cellphoneFeignClient.getCellphones(userId);
		if(cellphones == null) {
			result.put("Cellphone", "The user dont have a cellphone.");
		} else {
			if(cellphones.isEmpty()) {
				result.put("Cellphone", "The user dont have a cellphone.");
			}
			else {
				result.put("Cellphone", cellphones);
			}
		}
		
		List<Laptop> laptops = laptopFeignClient.getLaptops(userId);
		if(laptops == null) {
			result.put("Laptops", "The user dont have a laptop.");
		} else {
			if(laptops.isEmpty()) {
				result.put("Laptops", "The user dont have a laptop.");
			}		
			else {
				result.put("Laptops", laptops);
			}
		}
	
		return result;
	}


}