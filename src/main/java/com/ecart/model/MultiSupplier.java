package com.ecart.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.springframework.stereotype.Component;

@Entity
@Component
public class MultiSupplier {
	
	private int pPrice;
	private int pQty;
	
	@EmbeddedId
	private MultiSupplierID multiSupplierId;
	
	public MultiSupplierID getMultiSupplierId() {
		return multiSupplierId;
	}
	public void setMultiSupplierId(MultiSupplierID multiSupplierId) {
		this.multiSupplierId = multiSupplierId;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	public int getpQty() {
		return pQty;
	}
	public void setpQty(int pQty) {
		this.pQty = pQty;
	}
}