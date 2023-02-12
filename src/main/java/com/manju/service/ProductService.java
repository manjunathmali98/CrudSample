package com.manju.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.manju.entity.Product;
import com.manju.exception.ResourceNotFoundException;

@Service
public interface ProductService {

	Product addProduct(@Valid Product product);

	List<Product> getAllProducts();

	Product getProduct(Integer productId) throws ResourceNotFoundException;

	Product deleteProduct(Integer productId) throws ResourceNotFoundException;

}
