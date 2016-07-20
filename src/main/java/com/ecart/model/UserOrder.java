package com.ecart.model;

import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;


import org.springframework.stereotype.Component;

@Entity
@Component
@Table (name = "USERORDER")
public class UserOrder {
	
	@Id @GeneratedValue
	private int orderId;
	@ManyToOne
	@JoinColumn(name="uId")
	private User user;
	@OneToMany(fetch=FetchType.EAGER)
	@JoinTable(name="userOrder_cart", joinColumns=@JoinColumn(name="oId"), inverseJoinColumns=@JoinColumn(name="cartDetailId"))
	private List<CartDetails> cartList;
	private int total;
	@Embedded
	private Address shippingAdr;
	private com.ecart.model.PaymentMode.paymentMode paymentMode;
	
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<CartDetails> getCartList() {
		return cartList;
	}
	public void setCartList(List<CartDetails> cartList) {
		this.cartList = cartList;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Address getShippingAdr() {
		return shippingAdr;
	}
	public void setShippingAdr(Address shippingAdr) {
		this.shippingAdr = shippingAdr;
	}
	public com.ecart.model.PaymentMode.paymentMode getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(com.ecart.model.PaymentMode.paymentMode paymentMode) {
		this.paymentMode = paymentMode;
	}
}
