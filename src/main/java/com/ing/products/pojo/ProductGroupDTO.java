package com.ing.products.pojo;

import java.io.Serializable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * container ProductGroup DTO 
 * @author user1
 *
 */
@Setter
@Getter
@NoArgsConstructor
public class ProductGroupDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long groupId;
	private String groupName;
	private Long groupCount;

}
