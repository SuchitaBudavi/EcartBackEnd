package com.ecart.model;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class MultiSupplierID implements Serializable{
	
	@ManyToOne @JoinColumn(name="pId") 
	private Product product_FK;
	@ManyToOne @JoinColumn(name="cId")
	private Category category_FK;
	@ManyToOne @JoinColumn(name="sId")
	private Supplier supplier_FK;
	
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
}
