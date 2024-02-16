package com.xinduswishlistmanagement.Service;

import java.util.List;

import com.xinduswishlistmanagement.Exception.ProductException;
import com.xinduswishlistmanagement.Model.Product;

public interface ProductService {
	
	public Product addProduct(Product product) throws ProductException;
	
	public Product deleteProduct(Integer productId) throws ProductException;
	
	public Product updateProduct(Integer productId,Integer productPrice) throws ProductException;
	
	public Product viewProduct(Integer productId) throws ProductException;
	
	public List<Product> viewAllProducts() throws ProductException;

}
