package com.prajyot.product.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CreateProductRequest {

	private String name;
	private String category;
	private String brandName;
	private String model;
	private Double price;
}
