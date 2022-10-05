package com.cellphone.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cellphone.model.Cellphone;

@Repository
public interface CellphoneRepository extends JpaRepository<Cellphone, Integer>{

	List<Cellphone> findByUserId(int userId);
	
}
