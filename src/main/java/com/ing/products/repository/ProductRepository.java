package com.ing.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ing.products.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	//@Query(value = "select * from products where group_id=?1",nativeQuery = true)
    List<Product> findByGroupId(Long groupId);
}
