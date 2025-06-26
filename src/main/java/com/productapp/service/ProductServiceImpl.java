package com.productapp.service;

import java.util.List;

import com.productapp.dao.ProductRepository;
import com.productapp.dao.ProductRepositoryImpl;
import com.productapp.model.Product;

public class ProductServiceImpl implements ProductService{
	
	private ProductRepository productRepository;

    public ProductServiceImpl() {
        this.productRepository = new ProductRepositoryImpl();
    }

	@Override
	public void addProduct(Product p) {
		productRepository.insert(p);
		
	}

	@Override
	public void updateProduct(Product p) {
		productRepository.update(p);
		
	}

	@Override
	public void deleteProductById(int id) {
		productRepository.deleteById(id);
		
	}

	@Override
	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	@Override
	public List<Product> findProductsByName(String keyword) {
		return productRepository.findByName(keyword);
	}

	@Override
	public Product findById(int id) {
		return productRepository.findById(id);
	}

    

}
