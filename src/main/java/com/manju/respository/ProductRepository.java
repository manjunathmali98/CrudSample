package com.manju.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manju.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}
