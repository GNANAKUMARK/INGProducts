package com.ing.products.service;

import java.util.List;

import com.ing.products.entity.ProductGroup;
import com.ing.products.pojo.ProductGroupDTO;

public interface ProductGroupService {
	List<ProductGroupDTO> getProductGroups();

	int saveCount(Long groupId, Long counts);

	ProductGroup findById(Long groupId);
}
