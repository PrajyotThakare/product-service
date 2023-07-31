package com.prajyot.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.prajyot.product.dto.CreateProductRequest;
import com.prajyot.product.dto.CreateProductResponse;

@Service
public interface ProductService {

	List<CreateProductResponse> findAll();

	void save(CreateProductRequest product);

}
