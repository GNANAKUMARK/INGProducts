package com.ing.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ing.products.pojo.ProductDTO;
import com.ing.products.service.ProductService;


@RestController
public class ProductController {
	@Autowired

    ProductService service;

    

    @GetMapping("/products/{groupid}")

    public ResponseEntity<List<ProductDTO>> getProducts(@PathVariable("groupid") long id) {
    	
        List<ProductDTO> product = service.findByGroupId(id);
        return new ResponseEntity<List<ProductDTO>>(product , HttpStatus.OK);   

    }
}
