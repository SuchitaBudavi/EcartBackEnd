package com.ecart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
public class CartDetails {
	
	@Id @GeneratedValue //hiberanate needs one id hence declared, not used explicitly
	private int cartDetailId;
	
	@ManyToOne @JoinColumn(name="uId")
	private User user_FK;
	
	@ManyToOne @JoinColumn(name="pId")
	private Product product_FK;
	
	@ManyToOne @JoinColumn(name="cId")
	private Category category_FK;
	
	@ManyToOne @JoinColumn(name="sId")
	private Supplier supplier_FK;
	
	private int qty;
	
	private int price;

	public int getCartDetailId() {
		return cartDetailId;
	}

	public void setCartDetailId(int cartDetailId) {
		this.cartDetailId = cartDetailId;
	}


	public User getUser_FK() {
		return user_FK;
	}

	public void setUser_FK(User user_FK) {
		this.user_FK = user_FK;
	}

	public Product getProduct_FK() {
		return product_FK;
	}

	public void setProduct_FK(Product product_FK) {
		this.product_FK = product_FK;
	}

	public Category getCategory_FK() {
		return category_FK;
	}

	public void setCategory_FK(Category category_FK) {
		this.category_FK = category_FK;
	}

	public Supplier getSupplier_FK() {
		return supplier_FK;
	}

	public void setSupplier_FK(Supplier supplier_FK) {
		this.supplier_FK = supplier_FK;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
