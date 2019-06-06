package com.ing.products.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
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
	public List< ProductGroupDTO> getProductGroups() {
		LOGGER.info("inside getProductGroups");
		List<ProductGroupDTO> productGroupDTOlist = new ArrayList<ProductGroupDTO>();
		List <ProductGroup>productGroupList =  productGroupRepository.findAll();
		for(ProductGroup productGroup:productGroupList) {
			ProductGroupDTO ProductGroupDTO = new ProductGroupDTO();
			ProductGroupDTO.setGroupId(productGroup.getGroupId());
			ProductGroupDTO.setGroupName(productGroup.getGroupName());
			ProductGroupDTO.setGroupCount(productGroup.getCount());
			productGroupDTOlist.add(ProductGroupDTO);
		}
		
		return productGroupDTOlist;
	}
}
