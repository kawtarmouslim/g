package com.joseph.service.Impl;

import com.joseph.entity.Product;
import com.joseph.repository.ProdectRepository;
import com.joseph.service.IProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
@Transactional
public class ProductServiceImp implements IProduct {
@Autowired
private ProdectRepository productRepository;
    @Override
    public Product save(Product p) {

        return productRepository.save(p);
    }
    @Override
    public Product selectProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> selectAllProduct() {
        return productRepository.findAll();
    }

    @Override
    public String deleteProduct(Long id) {
        Product product = productRepository.findById(id).orElse(null);
        if (product != null) {
            productRepository.delete(product);
            return "Product deleted successfully.";
        }
        return "Product not found.";
    }

    @Override
    public Product updateProduct(Product product) {

        return productRepository.save(product);
    }
}
