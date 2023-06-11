package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Address {
	@Id
	@Column
	private Integer addressid;
	@Column
	private String city;
	@Column
	private Integer pincode;
	@Column
	private String colony;
	public Integer getAddressid() {
		return addressid;
	}
	public void setAddressid(Integer addressid) {
		this.addressid = addressid;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getPincode() {
		return pincode;
	}
	public void setPincode(Integer pincode) {
		this.pincode = pincode;
	}
	public String getColony() {
		return colony;
	}
	public void setColony(String colony) {
		this.colony = colony;
	}

}