package com.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;



@Component
@Entity
public class Cart{

	
	@Id
	@GeneratedValue
	private int cartId;
	private int cartProductId;
	
	
	private int cartOrderID;
	private Date cartOrderPlacedOn;
	private String paymentMode;
	
	@OneToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="email")
	private User cartUserDetails;
	private double cartPrice;
	private int cartStock;
	private String cartImage;
	private String cartProductName;
	private String status;
	
	
	public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getCartProductId() {
		return cartProductId;
	}
	public void setCartProductId(int cartProductId) {
		this.cartProductId = cartProductId;
	}
	public User getCartUserDetails() {
		return cartUserDetails;
	}
	public void setCartUserDetails(User cartUserDetails) {
		this.cartUserDetails = cartUserDetails;
	}
	public double getCartPrice() {
		return cartPrice;
	}
	public void setCartPrice(double cartPrice) {
		this.cartPrice = cartPrice;
	}
	public int getCartStock() {
		return cartStock;
	}
	public void setCartStock(int cartStock) {
		this.cartStock = cartStock;
	}
	public String getCartImage() {
		return cartImage;
	}
	public void setCartImage(String cartImage) {
		this.cartImage = cartImage;
	}
	public String getCartProductName() {
		return cartProductName;
	}
	public void setCartProductName(String cartProductName) {
		this.cartProductName = cartProductName;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public Cart()
	{
		
	}
	public Cart(int cartId, int cartProductId, User cartUserDetails, Double cartPrice,int cartStock,String cartProductName)
	{
		this.cartId=cartId;
		this.cartProductId=cartProductId;
		this.cartUserDetails=cartUserDetails;
		this.cartPrice=cartPrice;
		this.cartStock=cartStock;
		this.cartProductName=cartProductName;
	}
	public int getCartOrderID() {
		return cartOrderID;
	}
	public void setCartOrderID(int cartOrderID) {
		this.cartOrderID = cartOrderID;
	}
	public Date getCartOrderPlacedOn() {
		return cartOrderPlacedOn;
	}
	public void setCartOrderPlacedOn(Date cartOrderPlacedOn) {
		this.cartOrderPlacedOn = cartOrderPlacedOn;
	}
	public String getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}
	
	
}
