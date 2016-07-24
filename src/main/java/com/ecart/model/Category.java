package com.ecart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.stereotype.Component;

import com.sun.tracing.dtrace.ProviderAttributes;

@Entity
@Component
public class Category {

	@Id @GeneratedValue
	@Column(nullable=false, length=5)
	private int cId;
	@Column(nullable=false, length=20)
	@NotEmpty(message="Category Name is manditory")
	@Pattern(regexp="^[a-zA-Z0-9]*$",message="Special characters are not allowed")
	private String cName;
	
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
