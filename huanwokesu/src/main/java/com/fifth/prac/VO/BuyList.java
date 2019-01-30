package com.fifth.prac.VO;


public class BuyList {
	 private int productseq;
	 private String name;
	 private int price;
	 private int quantity;
	 private String indate;
	public BuyList(int productseq, String name, int price, int quantity, String indate) {
		super();
		this.productseq = productseq;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.indate = indate;
	}
	public BuyList() {
		super();
	}
	public int getProductseq() {
		return productseq;
	}
	public void setProductseq(int productseq) {
		this.productseq = productseq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	@Override
	public String toString() {
		return "BuyList [productseq=" + productseq + ", name=" + name + ", price=" + price + ", quantity=" + quantity
				+ ", indate=" + indate + "]";
	}
	
	 
}
