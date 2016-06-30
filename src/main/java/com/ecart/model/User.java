package com.ecart.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table (name = "USER_DETAILS")
@Component
public class User {
	
	@Id
	@GeneratedValue
	private String uId;
	@Column(length=20, nullable=false)
	private String fName;
	@Column(length=20, nullable=false)
	private String lName;
	@Column(length=50, nullable=false)
	private String email;
	@Column(length=12)
	private int contactNum;
	@Column(length=15, nullable=false)
	private String password;
	@Column
	private int isAdmin;
	
	/*@Embedded
	@AttributeOverrides({
		@AttributeOverride(name="street", column=@Column(name="shipping_street")),
		@AttributeOverride(name="city", column=@Column(name="shipping_city")),
		@AttributeOverride(name="state", column=@Column(name="shipping_state")),
		@AttributeOverride(name="pincode", column=@Column(name="shipping_pincode"))
		
	})
	private Address shippingAddr;
	@Embedded //this annotation is not compulsory as @Embeddable is already defined at class level
	private Address billingAddr;*/
	
	public String getuId() {
		return uId;
	}
	public void setuId(String uId) {
		this.uId = uId;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	/*public Address getBillingAddr() {
		return billingAddr;
	}
	public void setBillingAddr(Address billingAddr) {
		this.billingAddr = billingAddr;
	}
	public Address getShippingAddr() {
		return shippingAddr;
	}
	public void setShippingAddr(Address shippingAddr) {
		this.shippingAddr = shippingAddr;
	}
*/
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getContactNum() {
		return contactNum;
	}
	public void setContactNum(int contactNum) {
		this.contactNum = contactNum;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(int isAdmin) {
		this.isAdmin = isAdmin;
	}	
	
}
