package com.ecart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table (name = "PRODUCT")
@Component
public class Product {
	
	@Id @GeneratedValue
	private int pId;
	@ManyToOne @JoinColumn(name="cId")
	private Category category_FK;
	private String pBrand;
	private String pModel;
	private int pPrice;
	private int pQty;
	@ManyToOne @JoinColumn(name="sId")
	private Supplier supplier_FK;
	
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpBrand() {
		return pBrand;
	}
	public void setpBrand(String pBrand) {
		this.pBrand = pBrand;
	}
	public String getpModel() {
		return pModel;
	}
	public void setpModel(String pModel) {
		this.pModel = pModel;
	}
	public int getpPrice() {
		return pPrice;
	}
	public void setpPrice(int i) {
		this.pPrice = i;
	}
	public int getpQty() {
		return pQty;
	}
	public void setpQty(int pQty) {
		this.pQty = pQty;
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
