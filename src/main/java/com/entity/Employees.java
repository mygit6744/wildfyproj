package com.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Employees {
	@Id
	@Column
	private Integer empid;
	@Column
	private String empname;
	@Column
	private String city;
	@Column
	private Integer age;
	
	//@OneToMany(cascade = CascadeType.ALL)
	//@JoinColumn(name = "deptid")
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "deptid")
	private Set<Department> department;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "addressid")
	private List<Address> address;
	
	
	
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public Set<Department> getDepartment() {
		return department;
	}
	public void setDepartment(Set<Department> department) {
		this.department = department;
	}
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}

	
}