package com.ing.products.service;

import java.util.List;

import com.ing.products.entity.Product;

public interface ProductService {

	List<Product> findByGroupId(Long id);
	
}
