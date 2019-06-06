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
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.products.entity.Product;
import com.ing.products.repository.ProductRepository;
import com.ing.products.service.ProductServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@SuppressWarnings(value = { "all" })
public class IngProductServiceTest {
	
	@Mock
	ProductRepository repository;
	@InjectMocks
	ProductServiceImpl service;
	
	@Test
	public void whileFetchingProducts() {
		List<Product> list = new ArrayList<>();
		 Product product = new Product();
		 product.setId((long) 1);
		 product.setProductName("bank saving mortgage");
		 product.setProductDescription("for loan applying through online");
		 product.setGroupId((long) 1);
		 Mockito.when(repository.findByGroupId(product.getGroupId())).thenReturn(list);
		 List<Product> list1 = service.findByGroupId(product.getGroupId());
		 assertThat(list).isEqualTo(list1);
		
	}

}
