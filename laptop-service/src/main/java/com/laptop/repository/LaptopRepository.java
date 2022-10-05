package com.laptop.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.laptop.model.Laptop;

@Repository
public interface LaptopRepository extends JpaRepository<Laptop, Integer>{

	List<Laptop> findByUserId(int userId);
	
}
