package com.user.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.user.models.Laptop;

@FeignClient(name = "laptop-service",url = "http://localhost:8092", path="/laptop")
public interface LaptopFeignClient {

	@PostMapping()
	public Laptop save(@RequestBody Laptop laptop);
	
	@GetMapping("/user/{userId}")
	public List<Laptop> getLaptops(@PathVariable("userId") int userId);
}
