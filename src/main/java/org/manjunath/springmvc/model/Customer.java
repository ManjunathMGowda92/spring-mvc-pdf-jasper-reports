package org.manjunath.springmvc.model;

public class Customer {
	
	private String customerId;
	private String customerName;
	private Integer age;
	private String phoneNumber;
	private String address;
	private String batchNumber;
	
	public Customer() {}
	
	

	public Customer(String customerId, String customerName, Integer age, String phoneNumber, String address,
			String batchNumber) {
		this.customerId = customerId;
		this.customerName = customerName;
		this.age = age;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.batchNumber = batchNumber;
	}



	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getBatchNumber() {
		return batchNumber;
	}

	public void setBatchNumber(String batchNumber) {
		this.batchNumber = batchNumber;
	}
}
