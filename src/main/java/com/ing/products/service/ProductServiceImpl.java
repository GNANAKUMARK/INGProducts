package com.ing.products.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.products.entity.Product;
import com.ing.products.repository.ProductRepository;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired

    ProductRepository repository;



	@Override
	public List<Product> findByGroupId(Long groupId) {
		
		 return repository.findByGroupId(groupId);
	}
}
