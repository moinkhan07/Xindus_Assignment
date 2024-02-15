package com.xinduswishlistmanagement.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xinduswishlistmanagement.Service.ProductService;
import com.xinduswishlistmanagement.Service.UserService;
import com.xinduswishlistmanagement.Service.WishlistService;

@RestController
@RequestMapping("/home")
public class MainController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private WishlistService wishlistService;
	
	

}
