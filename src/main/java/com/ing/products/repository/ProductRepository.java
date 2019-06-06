package com.ing.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.products.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
