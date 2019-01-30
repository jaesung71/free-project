package com.fifth.prac.VO;


public class Customer {
    private String customerid;
	private String customerpw;
	private String name;
	private String phone;
	private String birthdate;
	private String address;
	private String indate;
	public Customer(String customerid, String customerpw, String name, String phone, String birthdate, String address,
			String indate) {
		super();
		this.customerid = customerid;
		this.customerpw = customerpw;
		this.name = name;
		this.phone = phone;
		this.birthdate = birthdate;
		this.address = address;
		this.indate = indate;
	}
	public Customer() {
		super();
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getCustomerpw() {
		return customerpw;
	}
	public void setCustomerpw(String customerpw) {
		this.customerpw = customerpw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", customerpw=" + customerpw + ", name=" + name + ", phone="
				+ phone + ", birthdate=" + birthdate + ", address=" + address + ", indate=" + indate + "]";
	}
	
}
