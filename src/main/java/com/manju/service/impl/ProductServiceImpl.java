package com.manju.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manju.entity.Product;
import com.manju.exception.ResourceNotFoundException;
import com.manju.respository.ProductRepository;
import com.manju.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public Product addProduct(@Valid Product product) {

		Product p = productRepository.save(product);
		return p;
	}

	@Override
	public List<Product> getAllProducts() {

		return productRepository.findAll();
	}

	@Override
	public Product getProduct(Integer productId) throws ResourceNotFoundException {

		return productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
	}

	@Override
	public Product deleteProduct(Integer productId) throws ResourceNotFoundException {

		Product product= productRepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + productId));

		productRepository.delete(product);

		return product;
	}

}
