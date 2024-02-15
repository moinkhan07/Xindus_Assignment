package com.xinduswishlistmanagement.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xinduswishlistmanagement.Exception.WishlistException;
import com.xinduswishlistmanagement.Model.Wishlist;
import com.xinduswishlistmanagement.Repository.ProductRepository;
import com.xinduswishlistmanagement.Repository.UserRepository;
import com.xinduswishlistmanagement.Repository.WishlistRepository;

@Service
public class WishlistServiceImplementation implements WishlistService{
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private WishlistRepository wishlistRepository;

	@Override
	public Wishlist addProductToWishlist(String userEmail, Integer ProductId) throws WishlistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Wishlist deleteProductFromWishlist(String userEmail, Integer ProductId) throws WishlistException {
		// TODO Auto-generated method stub
		return null;
	}

}
