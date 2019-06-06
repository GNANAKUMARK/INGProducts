package com.ing.products.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.products.pojo.ProductGroupDTO;
import com.ing.products.service.ProductGroupService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")

public class ProductGroupController {
	private static final Logger LOGGER = LogManager.getLogger(ProductGroupController.class);

	@Autowired
	ProductGroupService ProductGroupService;

	@GetMapping(value = "/productgroups")
	public ResponseEntity<List<ProductGroupDTO>> getProductGroups() {
		LOGGER.info("ProductGroupController inside getProductGroups");
		List<ProductGroupDTO> response = ProductGroupService.getProductGroups();
		return new ResponseEntity<>(response, HttpStatus.OK);
	}

}
