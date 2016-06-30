package com.ecart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.springframework.stereotype.Component;

@Entity
@Table (name = "PRODUCT")
@Component
public class Product {
	
	@Id @GeneratedValue
	private int pId;
	@ManyToOne @JoinColumn(name="cId")
	private Category cId;
	private String pBrand;
	private String pModel;
	private String pDesc;
	private int pPrice;
	private int pQty;
	@ManyToOne @JoinColumn(name="sId")
	private Supplier sId;
	
	
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
	
	public Category getcId() {
		return cId;
	}
	public void setcId(Category cId) {
		this.cId = cId;
	}
	public Supplier getsId() {
		return sId;
	}
	public void setsId(Supplier sId) {
		this.sId = sId;
	}
	public String getpDesc() {
		return pDesc;
	}
	public void setpDesc(String pDesc) {
		this.pDesc = pDesc;
	}
	
}
