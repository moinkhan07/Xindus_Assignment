package com.xinduswishlistmanagement.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xinduswishlistmanagement.Exception.ProductException;
import com.xinduswishlistmanagement.Exception.UserException;
import com.xinduswishlistmanagement.Exception.WishlistException;
import com.xinduswishlistmanagement.Model.Product;
import com.xinduswishlistmanagement.Model.Wishlist;
import com.xinduswishlistmanagement.Service.ProductService;
import com.xinduswishlistmanagement.Service.WishlistService;

@RestController
@RequestMapping("/api")
public class MainController {
		
	@Autowired
	private ProductService productService;
	
	@Autowired
	private WishlistService wishlistService;
	
	// Products Api's:-	
	
	@PostMapping("/products")
	public ResponseEntity<Product> addProductHandler(@RequestBody Product product) throws ProductException{
		Product addedProduct = productService.addProduct(product);
		return new ResponseEntity<>(addedProduct,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/products/{pId}")
	public ResponseEntity<Product> deleteProductHandler(@PathVariable("pId") Integer pId) throws ProductException{
		Product deletedProduct = productService.deleteProduct(pId);
		return new ResponseEntity<>(deletedProduct,HttpStatus.OK);
	}
	
	@PatchMapping("/products/{pId}/{price}")
	public ResponseEntity<Product> updateProductPriceHandler(@PathVariable("pId") Integer pId,@PathVariable("price") Integer updatedPrice) throws ProductException{
		Product updatedProduct = productService.updateProduct(pId, updatedPrice);
		return new ResponseEntity<>(updatedProduct,HttpStatus.OK);
	}
	
	@GetMapping("/products/{pId}")
	public ResponseEntity<Product> addProduct(@PathVariable("pId") Integer pId) throws ProductException{
		Product product = productService.viewProduct(pId);
		return new ResponseEntity<>(product,HttpStatus.OK);
	}
	
	@GetMapping("/products")
	public ResponseEntity<List<Product>> viewAllProducts() throws ProductException{
		List<Product> allProducts = productService.viewAllProducts();
		return new ResponseEntity<>(allProducts,HttpStatus.OK);
	}
	
	// Wishlist Api's :-
	
	@PostMapping("/wishlists/{pId}")
	public ResponseEntity<Wishlist> addProductToWishlistHandler(@PathVariable("pId") Integer pId) throws ProductException, WishlistException, UserException{
		Wishlist addedProduct = wishlistService.addProductToWishlist(pId);
		return new ResponseEntity<>(addedProduct,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/wishlists/{pId}")
	public ResponseEntity<Wishlist> deleteProductFromWishlistHandler(@PathVariable("pId") Integer pId) throws ProductException, WishlistException, UserException{
		Wishlist deletedProduct = wishlistService.deleteProductFromWishlist(pId);
		return new ResponseEntity<>(deletedProduct,HttpStatus.OK);
	}
	
	@GetMapping("/wishlists")
	public ResponseEntity<Wishlist> getLoggedInUserWishlistHandler() throws ProductException, WishlistException, UserException{
		Wishlist loggedInUserWishlist = wishlistService.getLoggedInUserWishlist();
		return new ResponseEntity<>(loggedInUserWishlist,HttpStatus.OK);
	}

}
