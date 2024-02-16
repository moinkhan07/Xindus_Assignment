package com.xinduswishlistmanagement.Service;

import java.util.List;
import java.util.Optional;

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
		return productRepository.save(product);
	}

	@Override
	public Product deleteProduct(Integer productId) throws ProductException {
		Optional<Product> opt = productRepository.findById(productId);
		if(opt.isEmpty()) {
			throw new ProductException("No such product is there with the productId "+ productId);
		}
		Product existingProduct = opt.get();
		productRepository.delete(existingProduct);
		return existingProduct;
	}

	@Override
	public Product updateProduct(Integer productId,Integer productPrice) throws ProductException {
		Optional<Product> opt = productRepository.findById(productId);
		if(opt.isEmpty()) {
			throw new ProductException("No such product is there with the productId "+ productId);
		}
		Product existingProduct = opt.get();
		existingProduct.setProductPrice(productPrice);
		return productRepository.save(existingProduct);
	}

	@Override
	public Product viewProduct(Integer productId) throws ProductException {
		Optional<Product> opt = productRepository.findById(productId);
		if(opt.isEmpty()) {
			throw new ProductException("No such product is there with the productId "+ productId);
		}
		Product existingProduct = opt.get();
		return existingProduct;
	}

	@Override
	public List<Product> viewAllProducts() throws ProductException {
		List<Product> existingProducts = productRepository.findAll();
		if (existingProducts == null) {
			throw new ProductException("Products does not exist");
		}
		return existingProducts;
	}

}
