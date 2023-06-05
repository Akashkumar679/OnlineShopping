package com.akash.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@Entity
@Table(name = "FLIPKART")
@XmlRootElement
public class FlipKart {


	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PROD_ID")
	private int productid;
	
	@Column(name = "PROD_TYPE")
	private String cetogories;
	

	@Column(name = "PROD_NAME")
	private String  productname;
	
	@Column(name = "PROD_PRICE")
	private String productprice;
}
