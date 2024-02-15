package com.xinduswishlistmanagement.Service;

import com.xinduswishlistmanagement.Exception.WishlistException;
import com.xinduswishlistmanagement.Model.Wishlist;

public interface WishlistService {
	
	public Wishlist addProductToWishlist(String userEmail, Integer ProductId) throws WishlistException;
	
	public Wishlist deleteProductFromWishlist(String userEmail, Integer ProductId) throws WishlistException;
	
}
