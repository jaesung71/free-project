package com.fifth.prac.VO;


public class Product {
    private String productseq;
	private String name;
	private int quantity;
	private int price;
	private String comments;
	private String indate;
	public Product(String productseq, String name, int quantity, int price, String comments, String indate) {
		super();
		this.productseq = productseq;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.comments = comments;
		this.indate = indate;
	}
	public Product() {
		super();
	}
	public String getProductseq() {
		return productseq;
	}
	public void setProductseq(String productseq) {
		this.productseq = productseq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getIndate() {
		return indate;
	}
	public void setIndate(String indate) {
		this.indate = indate;
	}
	@Override
	public String toString() {
		return "Product [productseq=" + productseq + ", name=" + name + ", quantity=" + quantity + ", price=" + price
				+ ", comments=" + comments + ", indate=" + indate + "]";
	}
	
	
	
}
