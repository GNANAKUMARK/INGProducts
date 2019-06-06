package com.ing.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ing.products.entity.Product;
import com.ing.products.service.ProductService;


@RestController
public class ProductController {
	@Autowired

    ProductService service;

    

    @GetMapping(value = "/products/{groupId}",produces = MediaType.APPLICATION_JSON_VALUE)

    public ResponseEntity<List<Product>> getProducts(@PathVariable("groupId") Long groupId) {
    	
        List<Product> product = service.findByGroupId(groupId);
        return new ResponseEntity<>(product , HttpStatus.OK);   

    }
}
