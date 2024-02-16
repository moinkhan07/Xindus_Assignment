package com.xinduswishlistmanagement.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.xinduswishlistmanagement.Exception.ProductException;
import com.xinduswishlistmanagement.Exception.UserException;
import com.xinduswishlistmanagement.Exception.WishlistException;
import com.xinduswishlistmanagement.Model.Product;
import com.xinduswishlistmanagement.Model.Users;
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
	public Wishlist addProductToWishlist(Integer ProductId) throws WishlistException,UserException,ProductException {
		String loggedInUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Optional<Users> opt = userRepository.findByEmail(loggedInUserEmail);
		if(opt.isEmpty()) {
			throw new UserException("User not found");
		}
		
		Optional<Product> optProduct = productRepository.findById(ProductId);
		if(optProduct.isEmpty()) {
			throw new ProductException("Product not found");
		}
		Product product = optProduct.get();
		Users loggedInUser = opt.get();
		
		Wishlist wishlist = loggedInUser.getWishlist();
        if (wishlist == null) {
            wishlist = new Wishlist();
            wishlistRepository.save(wishlist);
            loggedInUser.setWishlist(wishlist);
        }
        wishlist.getListOfProducts().add(product);
        userRepository.save(loggedInUser); 
        return wishlist;
	}

	@Override
	public Wishlist deleteProductFromWishlist(Integer ProductId) throws WishlistException,UserException,ProductException {
		String loggedInUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Optional<Users> opt = userRepository.findByEmail(loggedInUserEmail);
		if(opt.isEmpty()) {
			throw new UserException("User not found");
		}
		
		Optional<Product> optProduct = productRepository.findById(ProductId);
		if(optProduct.isEmpty()) {
			throw new ProductException("Product not found");
		}
		
		Product product = optProduct.get();
		Users loggedInUser = opt.get();
		
		Wishlist wishlist = loggedInUser.getWishlist();
	    if (wishlist == null) {
	        throw new WishlistException("Wishlist not found");
	    }
	    
	    wishlist.getListOfProducts().remove(product);
	    
	    userRepository.save(loggedInUser);
	    
	    return wishlist;
	    
	}

	@Override
	public Wishlist getLoggedInUserWishlist() throws WishlistException, UserException, ProductException {
		String loggedInUserEmail = SecurityContextHolder.getContext().getAuthentication().getName();
		
		Optional<Users> opt = userRepository.findByEmail(loggedInUserEmail);
		if(opt.isEmpty()) {
			throw new UserException("User not found");
		}
		Users loggedInUser = opt.get();
		
		Wishlist wishlist = loggedInUser.getWishlist();
		return wishlist;
	}

}
