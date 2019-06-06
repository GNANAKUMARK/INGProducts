package com.ing.products.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ing.products.entity.Product;
import com.ing.products.pojo.ProductDTO;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{

	@Query(value = "select * from products where group_Id=?1",nativeQuery = true)
    List<ProductDTO> findByGroupId(long id);
}
