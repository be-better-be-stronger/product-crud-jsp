package com.productapp.service;

import java.util.List;

import com.productapp.model.Product;



public interface ProductService {
	void addProduct(Product p);
    void updateProduct(Product p);
    void deleteProductById(int id);
    List<Product> getAllProducts();
    List<Product> findProductsByName(String keyword);
    Product findById(int id);
}
