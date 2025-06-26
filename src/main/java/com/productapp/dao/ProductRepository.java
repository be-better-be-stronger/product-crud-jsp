package com.productapp.dao;

import java.util.List;

import com.productapp.model.Product;

public interface ProductRepository {
	List<Product> findAll();
    Product findById(int id);
    List<Product> findByName(String keyword);
    void insert(Product p);
    void update(Product p);
    void deleteById(int id);
    boolean existsById(int id);
}
