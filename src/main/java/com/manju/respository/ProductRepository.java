package com.manju.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.manju.entity.Product;


public interface ProductRepository extends JpaRepository<Product, Integer> {

}
