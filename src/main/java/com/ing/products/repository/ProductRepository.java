package com.ing.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.products.entity.ProductDTO;

public interface ProductRepository extends JpaRepository<ProductDTO, Long>{

}
