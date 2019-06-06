package com.ing.products;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.products.entity.ProductGroup;
import com.ing.products.pojo.ProductGroupDTO;
import com.ing.products.repository.ProductGroupRepository;
import com.ing.products.service.ProductGroupServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductGroupServiceTest {

	@Mock
	ProductGroupRepository productGroupRepository;
	
	
	@InjectMocks
	ProductGroupServiceImpl productGroupServiceImpl;
	
	@Test
	public void  getProductGroupDetails() {
		List<ProductGroup> productGroupList = new ArrayList<ProductGroup>();
		ProductGroup productGroup =new ProductGroup();
		productGroup.setCount(1l);
		productGroup.setGroupId(2l);
		productGroup.setGroupName("Mortgage");
		productGroupList.add(productGroup);
		Mockito.when(productGroupRepository.findAll(new Sort(Sort.Direction.DESC,"count"))).thenReturn(productGroupList);
		List<ProductGroupDTO> resultList = productGroupServiceImpl.getProductGroups();
		 assertThat(productGroupList.get(0).getGroupName()).isEqualTo(resultList.get(0).getGroupName());
	}
}
