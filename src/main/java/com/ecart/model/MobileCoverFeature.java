package com.ecart.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class MobileCoverFeature {

	//Composite key =  pId + cId
	@EmbeddedId
	private ProductFeatureID mobileCoverFeatureId;
		
	private String color;
	private String material;
	private String caseType;
	private String mobileBrand;
	private String mobileModel;
	private String plainOrDesigned;
	
	
	public ProductFeatureID getMobileCoverFeatureId() {
		return mobileCoverFeatureId;
	}
	public void setMobileCoverFeatureId(ProductFeatureID mobileCoverFeatureId) {
		this.mobileCoverFeatureId = mobileCoverFeatureId;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getCaseType() {
		return caseType;
	}
	public void setCaseType(String caseType) {
		this.caseType = caseType;
	}
	public String getMobileBrand() {
		return mobileBrand;
	}
	public void setMobileBrand(String mobileBrand) {
		this.mobileBrand = mobileBrand;
	}
	public String getMobileModel() {
		return mobileModel;
	}
	public void setMobileModel(String mobileModel) {
		this.mobileModel = mobileModel;
	}
	public String getPlainOrDesigned() {
		return plainOrDesigned;
	}
	public void setPlainOrDesigned(String plainOrDesigned) {
		this.plainOrDesigned = plainOrDesigned;
	}
}
