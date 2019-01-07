package com.dao;

import java.util.List;

import com.model.Cart;



public interface CartDao {

	public void insertCart(Cart cart);
	/*public Cart getCartById(int pro_id, String userEmail);*/
	public void updateCart(Cart cm);
	public List<Cart> findByCartId(String userEmail);
	/*public void deleteCart(int cartId);
	public List<Cart> getPurchasedProducts(String userEmail);
	public int getCartOrderId(int cat_id);
	public List<Cart> getCartByCartId(int cart_id);*/
	public List<Cart> getCartByCartId(int cartId);
	public List<Cart> getPurchasedProducts(String userEmail);
	public void deleteCart(int cartId);
}
