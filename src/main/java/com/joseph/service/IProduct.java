package com.joseph.service;

import com.joseph.entity.Product;

import java.util.List;

public interface IProduct {
    public Product save(Product p);

    public Product selectProduct(Long id);

    public List<Product> selectAllProduct();

    public String deleteProduct(Long id);

    public Product updateProduct(Product product);
}
