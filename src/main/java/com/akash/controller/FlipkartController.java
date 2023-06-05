package com.akash.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.akash.entity.FlipKart;
import com.akash.service.FlipKartService;

@RestController
public class FlipkartController {

	@Autowired
	private FlipKartService service;
	
	@PostMapping(value = "/addProd" ,produces =   MediaType.APPLICATION_XML_VALUE)
	public ResponseEntity<FlipKart> addProduct(@RequestBody FlipKart faKart){
		service.saveProd(faKart);
		return new ResponseEntity<FlipKart>(faKart,HttpStatus.CREATED);
   }
	@PostMapping(value = "/addListProd",produces =  MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FlipKart>> addlistProd(@RequestBody List<FlipKart> faList){
		service.saveProducts(faList);
		return new ResponseEntity<List<FlipKart>>(faList,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "getAllitem",produces =     MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<FlipKart>> findAllprod(){
		List<FlipKart> findAllKart=service.prodfindAll();
		return new ResponseEntity<List<FlipKart>>(findAllKart,HttpStatus.ACCEPTED);
	}
	
	@GetMapping(value = "/findById/{id}",produces =   MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlipKart> prodFindById(@PathVariable("id") int prodid){
		FlipKart msgString=
				service.prodgetById(prodid);
		return new ResponseEntity<FlipKart>(msgString,HttpStatus.ACCEPTED);
		
	}
	@GetMapping(value = "/Category",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> prodfindBycetegory(String prodtype){
	 List<String>	data=service.prodgetbyCetogorie(prodtype);
	
		return new ResponseEntity<List<String>>(data, HttpStatus.OK);
	}
	
	@GetMapping(value = "/FindbyProdName",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<String>> prodfindByProdName(String prodname){
		List<String> findList=service.prodgetByName(prodname);
		
		return new ResponseEntity<List<String>>(findList,HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/Delete/{pid}")
	public ResponseEntity<String> deleteprodByid(@PathVariable("pid") int prodid){
		service.prodDeletebyid(prodid);
		String msg="delete Success";
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
	@PutMapping(value = "/UpdateOrder",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<FlipKart> prodUpdate(FlipKart fKart){
		service.updateItem(fKart);
		
		return new ResponseEntity<FlipKart>(fKart,HttpStatus.ACCEPTED);
	}
}
