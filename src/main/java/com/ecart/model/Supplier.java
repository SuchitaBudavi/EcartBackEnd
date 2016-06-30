package com.ecart.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Supplier {

	@Id 
	@Column(nullable = false, length=5)
	private int sId;
	
	@Column(nullable = false, length=20)
	private String sName;
	
	@Embedded
	private Address sAddress;
	
	public int getsId() {
		return sId;
	}
	public void setsId(int sId) {
		this.sId = sId;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public Address getsAddress() {
		return sAddress;
	}
	public void setsAddress(Address sAddress) {
		this.sAddress = sAddress;
	}
	
	
}
