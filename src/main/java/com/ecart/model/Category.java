package com.ecart.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Category {

	@Id
	@Column(nullable=false, length=5)
	private int cId;
	@Column(nullable=false, length=20)
	private String cName;
	/*@OneToMany
	private Collection<Product> product;
	
	public Collection<Product> getProduct() {
		return product;
	}
	public void setProduct(Collection<Product> product) {
		this.product = product;
	}*/
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
}
