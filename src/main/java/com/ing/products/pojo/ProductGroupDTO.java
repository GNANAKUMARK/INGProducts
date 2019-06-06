package com.ing.products.pojo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * container ProductGroup DTO 
 * @author user1
 *
 */
@Setter
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
public class ProductGroupDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Long groupId;
	private String groupName;
	private Long groupCount;

}
