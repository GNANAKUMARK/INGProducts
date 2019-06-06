package com.ing.products;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.products.controller.ProductGroupController;
import com.ing.products.pojo.ProductGroupDTO;
import com.ing.products.service.ProductGroupService;
import com.ing.products.service.ProductGroupServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductGroupController.class, secure = false)

public class ProductGroupControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	ProductGroupService productGroupService;

	@Test
	public void fetchProductGroups() throws Exception {
		List<ProductGroupDTO> productGroupDTOlist = new ArrayList<ProductGroupDTO>();
		ProductGroupDTO productGroupDTO = new ProductGroupDTO();
		productGroupDTO.setGroupCount(1l);
		productGroupDTO.setGroupId(1l);
		productGroupDTO.setGroupName("Mortgage");
		productGroupDTOlist.add(productGroupDTO);
		Mockito.when(productGroupService.getProductGroups()).thenReturn(productGroupDTOlist);

		mockMvc.perform(get("/api/productgroups").contentType(MediaType.APPLICATION_JSON).content(asJsonString("")))
				.andExpect(status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
