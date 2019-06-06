package com.ing.products.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.products.repository.ProductRepository;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")

public class ProductGroupController {
	private static final Logger LOGGER = LogManager.getLogger(ProductGroupController.class);
	@Autowired
	ProductRepository productRepository;
	
	private void test() {
		//dao.findAll(new Sort(Sort.Direction.DESC, "<colName>"));
		
		productRepository.findAll(new Sort(Sort.Direction.DESC,"count"));
	}
	
	
}
