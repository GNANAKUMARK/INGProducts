package com.ing.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.products.entity.Product;
import com.ing.products.entity.ProductGroup;
import com.ing.products.exception.DataNotFoundException;
import com.ing.products.service.ProductGroupService;
import com.ing.products.service.ProductService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(path = "/api")
public class ProductController {
	
	@Autowired

    ProductService service;

	@Autowired
	ProductGroupService productGroupService;

    @GetMapping(value = "/products/{groupId}",produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<List<Product>> getProducts(@PathVariable("groupId") Long groupId) {
    	
        List<Product> product = service.findByGroupId(groupId);
        
        if(product.isEmpty()) {
        	throw new DataNotFoundException("Data not found");
        }
        
        ProductGroup  productGroup = productGroupService.findById(groupId);
       
        Long counts= productGroup.getCount();
       counts++;
		productGroupService.saveCount(groupId,counts);
     
       // count(groupId);
        return new ResponseEntity<>(product , HttpStatus.OK);   

    }


	/*
	 * private void count(Long groupId) { Long counts = null; counts++;
	 * productGroupService.saveCount(groupId,counts);
	 * 
	 * }
	 */
}
