package com.ing.products.service;

import java.util.List;

import com.ing.products.pojo.ProductDTO;

public interface ProductService {

	List<ProductDTO> findByGroupId(long id);
	
}
