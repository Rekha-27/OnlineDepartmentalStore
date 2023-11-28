package com.project.pojo;

public class Product extends Item {
	private int productid;
	private String produtname;
	private double sellingprice;
	private int availablequantity;
	public double getSellingPrice() {
		return sellingprice;
	}
	public void setSellingprice(double sellingprice) {
		this.sellingprice = sellingprice;
	}
	public int getProductid() {
		return productid;
	}
	public void setProductid(int productid) {
		this.productid = productid;
	}
	public String getProdutname() {
		return produtname;
	}
	public void setProdutname(String produtname) {
		this.produtname = produtname;
	}
		public int getAvailablequantity() {
		return availablequantity;
	}
	public void setAvailablequantity(int availablequantity) {
		this.availablequantity = availablequantity;
	}
	public Product(int productid, String produtname, double sellingprice, int availablequantity,String catagory,double buyingprice) {
		super(catagory,buyingprice);
		this.productid = productid;
		this.produtname = produtname;
		this.sellingprice = sellingprice;
		this.availablequantity = availablequantity;
		
	}
	public Product() {
		
	}
	
	
}
