package com.project.pojo;

public class Item  {
	private String itemname;
	private String catagory;
	private double buyingprice;
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getCatagory() {
		return catagory;
	}
	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}
	public double getBuyingprice() {
		return buyingprice;
	}
	public void setBuyingprice(double buyingprice) {
		this.buyingprice = buyingprice;
	}
	public Item(String catagory, double buyingprice) {
		super();
		this.catagory = catagory;
		this.buyingprice = buyingprice;
	}
	public Item() {
		
	}
	
}
