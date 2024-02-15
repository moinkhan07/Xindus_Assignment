package com.xinduswishlistmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xinduswishlistmanagement.Model.Wishlist;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer>{

}
