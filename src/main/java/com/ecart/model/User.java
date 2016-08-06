package com.ecart.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.ecart.model.Address;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;


@Entity
@Table (name = "USER_DETAILS")
@Component
public class User implements Serializable{
	
	@Id
	@GeneratedValue
	private String uId;
	@Column(length=20, nullable=false)
	private String fName;
	@Column(length=20, nullable=false)
	private String lName;
	@Column(length=50, nullable=false)
	@NotEmpty(message="Email is manditory")
	@Email(message="Please user correct email id")
	private String email;
	@Column(length=12)
	private int contactNum;
	@Column(length=50, nullable=false)
	private String password;
	@Column
	private int isAdmin;
	private boolean enabled;
	@ElementCollection
	private List<Address> addressList;
	
	@OneToMany(fetch=FetchType.EAGER)
/*	@JoinTable(name="user_cart", joinColumns=@JoinColumn(name="uId"), inverseJoinColumns=@JoinColumn(name="cartDetailId"))
	private List<CartDetails> uCart;*/
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

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Address> getAddressList() {
		return addressList;
	}
	public void setAddressList(List<Address> addressList) {
		this.addressList = addressList;
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
