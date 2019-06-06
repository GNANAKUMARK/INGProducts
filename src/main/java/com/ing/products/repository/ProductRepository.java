package com.ing.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.products.entity.Products;

public interface ProductRepository extends JpaRepository<Products, Long>{

}
