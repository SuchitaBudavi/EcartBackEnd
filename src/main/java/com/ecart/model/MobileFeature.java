package com.ecart.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class MobileFeature {
	
	//Composite key =  pId + cId
	@EmbeddedId
	private ProductFeatureID mobileFeatureId;
	
	//Memory & Processor
	private int internalMemory;
	private double ram;
	private String processor;
	private String os;
	
	//Display
	private String resolution;
	private double screenSize;
	
	//Camera
	private double frontCam;
	private double rareCam;
	
	//battery
	private int battery;
	private String batteryDesc;
	
	//color
	private String color;


	public ProductFeatureID getMobileFeatureId() {
		return mobileFeatureId;
	}

	public void setMobileFeatureId(ProductFeatureID mobileFeatureId) {
		this.mobileFeatureId = mobileFeatureId;
	}

	public int getInternalMemory() {
		return internalMemory;
	}

	public void setInternalMemory(int internalMemory) {
		this.internalMemory = internalMemory;
	}

	public double getRam() {
		return ram;
	}

	public void setRam(double ram) {
		this.ram = ram;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public double getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(double screenSize) {
		this.screenSize = screenSize;
	}

	public double getFrontCam() {
		return frontCam;
	}

	public void setFrontCam(double frontCam) {
		this.frontCam = frontCam;
	}

	public double getRareCam() {
		return rareCam;
	}

	public void setRareCam(double rareCam) {
		this.rareCam = rareCam;
	}

	public int getBattery() {
		return battery;
	}

	public void setBattery(int battery) {
		this.battery = battery;
	}

	public String getBatteryDesc() {
		return batteryDesc;
	}

	public void setBatteryDesc(String batteryDesc) {
		this.batteryDesc = batteryDesc;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
