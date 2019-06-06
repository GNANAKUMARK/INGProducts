package com.ing.products;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.ing.products.controller.ProductController;
import com.ing.products.entity.Product;
import com.ing.products.service.ProductService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc

public class IngProductsApplicationTests {

	@Autowired
    private MockMvc mockMvc;
	
	@MockBean
	ProductService service;
	
	@InjectMocks
	ProductController controller;
	
	@Autowired private WebApplicationContext wac;
	 
	@Before
	public void setup() { 
		this.mockMvc =  MockMvcBuilders.webAppContextSetup(wac).build();
	
	
}
	@Test
	public void whenFetchingProducts() throws Exception {
		List<Product> list = new ArrayList<>();
		 Product product = new Product();
		 product.setId((long) 1);
		 product.setProductName("bank saving mortgage   !!!");
		 product.setProductDescription("for loan applying through online");
		 product.setGroupId((long) 1);
		 list.add(product);
		 Mockito.when(service.findByGroupId(product.getGroupId())).thenReturn(list);
		
		mockMvc.perform(get("/api/products/{groupId}",1).accept(MediaType.
				 APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(jsonPath("$[0].id").exists()).andDo(print()); 
	}
}
