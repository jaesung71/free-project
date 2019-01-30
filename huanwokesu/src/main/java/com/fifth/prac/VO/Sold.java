package com.fifth.prac.VO;


public class Sold {
	 private String soldseq;
	 private String customerid;
	 private String productseq;
	 private String indate;
	 private int quantity;
	public Sold(String soldseq, String customerid, String productseq, String indate, int quantity) {
		super();
		this.soldseq = soldseq;
		this.customerid = customerid;
		this.productseq = productseq;
		this.indate = indate;
		this.quantity = quantity;
	}
	public Sold() {
		super();
	}
	@Override
	public String toString() {
		return "Sold [soldseq=" + soldseq + ", customerid=" + customerid + ", productseq=" + productseq + ", indate="
				+ indate + ", quantity=" + quantity + "]";
	}
	public String getSoldseq() {
		return soldseq;
	}
	public void setSoldseq(String soldseq) {
		this.soldseq = soldseq;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	public String getProductseq() {
		return productseq;
	}
	public void setProductseq(String productseq) {
		this.productseq = productseq;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	 
}
