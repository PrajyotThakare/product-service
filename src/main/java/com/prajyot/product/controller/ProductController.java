package com.prajyot.product.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.prajyot.product.dto.CreateProductRequest;
import com.prajyot.product.dto.CreateProductResponse;
import com.prajyot.product.service.ProductService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/all-Products")
	@ResponseStatus(HttpStatus.OK)
	public List<CreateProductResponse> getAllProducts(){
		log.info("finding products...");
		return service.findAll();
	}
	
	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	public void createNewProduct(@RequestBody CreateProductRequest product) {	
		log.info("creating product... "+product);
		service.save(product);
	}
	
	@GetMapping("/welcome")
	@ResponseStatus(HttpStatus.OK)
	public String welcome() {
		log.info("Namaste World...!");
		return "Namaste World...!";
	}
}
