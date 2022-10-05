package com.user.feignClients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.user.models.Cellphone;

@FeignClient(name = "cellphone-service",url = "http://localhost:8091", path="/cellphone")
public interface CellphoneFeignClient {

	@PostMapping()
	public Cellphone save(@RequestBody Cellphone cellphone);
	
	@GetMapping("/user/{userId}")
	public List<Cellphone> getCellphones(@PathVariable("userId") int userId);
}