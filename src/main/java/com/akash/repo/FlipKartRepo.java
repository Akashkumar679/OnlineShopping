package com.akash.repo;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.akash.entity.FlipKart;

public interface FlipKartRepo extends JpaRepository<FlipKart, Serializable>{

	@Query(value = "select * from FLIPKART where PROD_NAME=?",nativeQuery = true)
	List<String> findByName(String prodname);

	@Query(value = "select * from FLIPKART where PROD_TYPE=?",nativeQuery = true)
	List<String> findBycetogorie(String cetegory);

}
