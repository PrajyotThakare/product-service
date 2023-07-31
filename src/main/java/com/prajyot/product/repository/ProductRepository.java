package com.prajyot.product.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.prajyot.product.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	
	Product findByModel(String modelName);

}
