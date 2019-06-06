package com.ing.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ing.products.entity.ProductGroup;

@Repository
public interface ProductGroupRepository extends JpaRepository<ProductGroup, Long> {

	@Modifying
	@Query(value = "update product_group set count=?2 where group_id=?1",nativeQuery = true)
	int save(Long groupId, Long counts);

	
}
