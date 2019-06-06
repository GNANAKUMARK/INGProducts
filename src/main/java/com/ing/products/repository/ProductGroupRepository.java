package com.ing.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.products.entity.ProductGroupDTO;

public interface ProductGroupRepository extends JpaRepository<ProductGroupDTO, Long> {

}
