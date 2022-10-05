package com.user.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.user.models.Motorcycle;

@FeignClient(name = "motorcycle-service",url = "http://localhost:8092", path="/moto")
public interface MotorcycleFeignClient {

	@PostMapping()
	public Motorcycle save(@RequestBody Motorcycle moto);
	
	@GetMapping("/user/{userId}")
	public List<Motorcycle> getMotos(@PathVariable("userId") int userId);
}
