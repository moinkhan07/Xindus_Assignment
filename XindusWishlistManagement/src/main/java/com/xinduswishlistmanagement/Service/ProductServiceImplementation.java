package com.xinduswishlistmanagement.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinduswishlistmanagement.Exception.ProductException;
import com.xinduswishlistmanagement.Model.Product;
import com.xinduswishlistmanagement.Repository.ProductRepository;

@Service
public class ProductServiceImplementation implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product addProduct(Product product) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product deleteProduct(Integer productId) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product updateProduct(Integer productId, Product product) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product viewProduct(Integer productId) throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> viewAllProducts() throws ProductException {
		// TODO Auto-generated method stub
		return null;
	}

}
