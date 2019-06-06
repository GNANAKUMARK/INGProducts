package com.ing.products.entity;

import java.io.Serializable;

import javax.annotation.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;




@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
@SuppressWarnings(value = { "all" })
public class ProductGroup implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long groupId;
	private String groupName;
	private Long count;
}
