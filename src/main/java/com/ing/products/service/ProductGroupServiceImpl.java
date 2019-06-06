package com.ing.products.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.ing.products.entity.ProductGroup;
import com.ing.products.pojo.ProductGroupDTO;
import com.ing.products.repository.ProductGroupRepository;


@Service

public class ProductGroupServiceImpl implements ProductGroupService {
	private static final 
	Logger LOGGER = LogManager.getLogger(ProductGroupServiceImpl.class);
	@Autowired
	ProductGroupRepository productGroupRepository;
	@Override
	public List<ProductGroupDTO> getProductGroups() {
		LOGGER.info("inside getProductGroups");
		List<ProductGroupDTO> productGroupDTOlist = new ArrayList<>();
		List <ProductGroup>productGroupList =  productGroupRepository.findAll(new Sort(Sort.Direction.DESC,"count"));
		for(ProductGroup productGroup:productGroupList) {
			ProductGroupDTO productGroupDTO = new ProductGroupDTO();
			productGroupDTO.setGroupId(productGroup.getGroupId());
			productGroupDTO.setGroupName(productGroup.getGroupName());
			productGroupDTO.setGroupCount(productGroup.getCount());
			productGroupDTOlist.add(productGroupDTO);
		}
		
		return productGroupDTOlist;
	}
	
	@Transactional
	public int saveCount(Long groupId, Long counts) {
		
		
		return productGroupRepository.save(groupId,counts);
	}

	
	public ProductGroup findById(Long groupId) {
		
		return productGroupRepository.findById(groupId).orElse(null);
	}
}
