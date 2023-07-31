package com.prajyot.product.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prajyot.product.dto.CreateProductRequest;
import com.prajyot.product.dto.CreateProductResponse;
import com.prajyot.product.entity.Product;
import com.prajyot.product.repository.ProductRepository;
import com.prajyot.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository repository;

	@Override
	public List<CreateProductResponse> findAll() {
		log.info("Inside Service..");
//		return repository.findAll().stream().map(product -> mapToProductResponse(product)).toList();
		return repository.findAll().stream().map(this::mapToProductResponse).toList();
	}

	private CreateProductResponse mapToProductResponse(final Product product) {
		return CreateProductResponse.builder().id(product.getId()).name(product.getName())
				.category(product.getCategory()).brandName(product.getBrandName()).model(product.getModel())
				.price(product.getPrice()).build();
	}

	@Override
	public void save(final CreateProductRequest request) {

		Product product = Product.builder().name(request.getName()).category(request.getCategory())
				.brandName(request.getBrandName()).model(request.getModel()).price(request.getPrice()).build();
		repository.save(product);
		log.info("Product saved with id : {}", product.getId());
	}

}
