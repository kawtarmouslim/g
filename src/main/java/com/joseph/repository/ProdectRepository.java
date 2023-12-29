package com.joseph.repository;

import com.joseph.entity.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("productRepository")
public interface ProdectRepository extends JpaRepository<Product,Long> {
}
