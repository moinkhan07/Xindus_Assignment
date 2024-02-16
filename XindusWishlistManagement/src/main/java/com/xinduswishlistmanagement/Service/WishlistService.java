package com.xinduswishlistmanagement.Service;

import com.xinduswishlistmanagement.Exception.ProductException;
import com.xinduswishlistmanagement.Exception.UserException;
import com.xinduswishlistmanagement.Exception.WishlistException;
import com.xinduswishlistmanagement.Model.Wishlist;

public interface WishlistService {
	
	public Wishlist addProductToWishlist(Integer ProductId) throws WishlistException,UserException,ProductException;
	
	public Wishlist deleteProductFromWishlist(Integer ProductId) throws WishlistException,UserException,ProductException;
	
	public Wishlist getLoggedInUserWishlist() throws WishlistException,UserException,ProductException; 

}
