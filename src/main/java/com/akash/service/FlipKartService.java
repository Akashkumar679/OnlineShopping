package com.akash.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.akash.entity.FlipKart;
import com.akash.repo.FlipKartRepo;

@Service
public class FlipKartService {

	@Autowired
	private FlipKartRepo repo;
	
	public FlipKart saveProd(FlipKart fKart){
		return repo.save(fKart);
	}
	
	public List<FlipKart> saveProducts(List<FlipKart> faKart){
		return repo.saveAll(faKart);
	}
	
	public FlipKart prodgetById(int prodid) {
		return 
		 repo.findById(prodid).orElse(null);
	}
	
	public List<FlipKart> prodfindAll() {
		return repo.findAll();
	}

	public List<String> prodgetbyCetogorie(String cetogorie){
		return repo.findBycetogorie(cetogorie);
	}
	public List<String> prodgetByName(String prodname) {
		return repo.findByName(prodname);
	}
	public String prodDeletebyid(int id) {
		repo.deleteById(id);
		return "product deleted successfully"+id;
	}
	public FlipKart updateItem(FlipKart fKart) {
		FlipKart existingItem=repo.findById(fKart.getProductid()).orElse(null);
		existingItem.setProductname(fKart.getProductname());
		existingItem.setCetogories(fKart.getCetogories());
		existingItem.setProductprice(fKart.getProductprice());
		return repo.save(existingItem);
	}
}
