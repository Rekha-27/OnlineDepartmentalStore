package com.project.service;

import java.sql.SQLException;
import java.util.*;

import com.jdbc.project.DAO.*;
import com.project.pojo.Item;
import com.project.pojo.Product;

public class ProductService {
	private Scanner sc;
	private ProductDAO pdao;
	private List<Product> plist;
	private List<Item> ilist;
	public ProductService() {
		pdao=new ProductDAO();
		plist=new ArrayList();
		ilist=new ArrayList();
		sc=new Scanner(System.in);
	}
	public void addProductAdmin() throws SQLException {
		System.out.println("*******************ADD PRODUCTS************************");
		System.out.println("How many products do u want to add:");
		int noofproduct=sc.nextInt();
		for(int i=0;i<noofproduct;i++) {
			Product product=new Product();
			Item item=new Item();
			System.out.println("Enter product id:");
			int proid=sc.nextInt();
			product.setProductid(proid);
			System.out.println("Enter product name:");
			String proname=sc.next();
			product.setItemname(proname);
			product.setProdutname(proname);
			item.setItemname(proname);
			System.out.println("enter catagory of product:");
			product.setCatagory(sc.next());
			item.setCatagory(product.getCatagory());
			System.out.println("enter product buying price:");
			product.setBuyingprice(sc.nextDouble());
			item.setBuyingprice(product.getBuyingprice());
			product.setSellingprice((product.getBuyingprice()*0.5)+product.getBuyingprice());
			System.out.println("Enter no of quantity:");
			product.setAvailablequantity(sc.nextInt());
			plist.add(product);
			ilist.add(item);
			System.out.println("product is added successfully......");
			System.out.println("********************************************************");
	   }
		pdao.addProduct(plist,ilist);
	}
	public void userDisplayProduct() throws SQLException {
		pdao.displayUserProduct();
	}
	public void display() throws SQLException {
		pdao.displayAdminProduct();
	}
	public void searchById() throws SQLException {
		pdao.SearchByProductId();
	}
	public void searchByCatagory() throws SQLException {
		pdao.searchProductByCatagory();
	}
	public void searchByName() throws SQLException {
		pdao.searchByProductName();
	}
	public void totalCost() throws SQLException {
		pdao.totalCostProduct();
	}
	public void filterPrice() throws SQLException {
		pdao.filterByprice();
	}
	public void profitcatagory() throws SQLException {
		pdao.ProfitByCatagory();
	}
	public void customerBuyProduct(String username) throws SQLException {
		pdao.buyProduct(username);
	}
}
