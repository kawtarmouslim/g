package com.joseph.controller;

import com.joseph.entity.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    // Sample list to simulate data storage
    private List<Product> productList = new ArrayList<>();

    @GetMapping("/list")
    public String listProducts(Model model) {
        model.addAttribute("listproduct", productList);
        return "list-p";
    }

    @GetMapping("/new")
    public String showProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "from-p";
    }

    @PostMapping("/insert")
    public String insertProduct(@ModelAttribute Product product) {
        // Logic to save the product to the list or database
        productList.add(product);
        return "redirect:list-p";
    }
@GetMapping("/edit")
public String showEditForm(@RequestParam Long id, Model model) {
    // Logic to retrieve product by id
    Product product = getProductById(id);
    model.addAttribute("product", product);
    return "form-p";
}
    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product) {
        // Logic to update the product in the list or database
        Product existingProduct = getProductById(product.getId());
        existingProduct.setDesignation(product.getDesignation());
        existingProduct.setPrix(product.getPrix());
        existingProduct.setQuantite(product.getQuantite());
        return "redirect:list-p";
    }
    @GetMapping("/delete")
    public String deleteProduct(@RequestParam Long id) {
        // Logic to delete the product from the list or database
        productList.removeIf(product -> product.getId().equals(id));
        return "redirect:list-p";
    }

    // Helper method to retrieve a product by id (replace this with database access)
    private Product getProductById(Long id) {
        return productList.stream()
                .filter(product -> product.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
