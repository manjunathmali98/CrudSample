package com.manju.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.manju.entity.Product;
import com.manju.exception.ResourceNotFoundException;
import com.manju.service.ProductService;

public class ProductController {

	@Autowired
	ProductService productService;

	@PostMapping("/product")
	public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product) {

		Product c = productService.addProduct(product);

		return ResponseEntity.ok().body(c);
	}

	@GetMapping("/products")
	public ResponseEntity<List<Product>> getAllProducts() {

		List<Product> products = productService.getAllProducts();
		return ResponseEntity.ok().body(products);
	}

	@GetMapping("/Products/{id}")
	public ResponseEntity<Product> getEmployeeById(@PathVariable(value = "id") Integer ProductId)
			throws ResourceNotFoundException {
		Product c = productService.getProduct(ProductId);

		return ResponseEntity.ok().body(c);
	}

	@PutMapping("/Products/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Integer ProductId,
			@Valid @RequestBody Product ProductDetails) throws ResourceNotFoundException {
		Product c = productService.getProduct(ProductId);

		c.setPid(ProductDetails.getPid());
		c.setPrice(ProductDetails.getPrice());
		c.setProductName(ProductDetails.getProductName());
		c.setQty(ProductDetails.getQty());
		final Product updatedProduct = productService.addProduct(c);
		return ResponseEntity.ok(updatedProduct);
	}

	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable(value = "id") Integer ProductId)
			throws ResourceNotFoundException {

		Product c = productService.deleteProduct(ProductId);

		return ResponseEntity.ok(c);
	}
}

