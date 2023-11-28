package com.project.DaAO;

import java.util.stream.*;
import java.util.*;
import java.util.Map.Entry;

import com.project.pojo.Product;

public class AdminUserOperations {
	private Scanner sc;
	private double totalcost;
	private double profit;
	private Map<Integer,Product>prolist;
	public AdminUserOperations() {
		prolist=new HashMap<>();
		sc=new Scanner(System.in);
	}
	public void display() {
		Product p1=new Product(101,"chairs",5000,2,"furniture",4000);
		prolist.put(p1.getProductid(), p1);
		Product p2=new Product(102,"tables",7000,1,"furniture",5000);
		prolist.put(p2.getProductid(), p2);
	}
	public void addProductAdmin() {
		System.out.println("*******************************************");
		System.out.println("How many products do u want to add:");
		int noofproduct=sc.nextInt();
		for(int i=0;i<noofproduct;i++) {
			Product product=new Product();
			System.out.println("Enter product id:");
			int proid=sc.nextInt();
			product.setProductid(proid);
			System.out.println("Enter product name:");
			String proname=sc.next();
			product.setItemname(proname);
			product.setProdutname(proname);
			System.out.println("enter catagory of product:");
			product.setCatagory(sc.next());
			System.out.println("enter product buying price:");
			product.setBuyingprice(sc.nextDouble());
			product.setSellingprice((product.getBuyingprice()*0.5)+product.getBuyingprice());
			System.out.println("Enter no of quantity:");
			product.setAvailablequantity(sc.nextInt());
			prolist.put(proid, product);
			System.out.println("product is added successfully......");
			System.out.println("********************************************************");
		}
		
	}
	public void displayProducts() {
		Set<Map.Entry<Integer, Product>> entrySet = prolist.entrySet();
		entrySet.stream().forEach(pro->
		{
			System.out.println("product id is:"+pro.getValue().getProductid());
			System.out.println("product name is:"+pro.getValue().getProdutname());
			System.out.println("product catagory is:"+pro.getValue().getCatagory());
			System.out.println("product selling price is :"+pro.getValue().getSellingPrice());
			System.out.println("product avaliable quantity is:"+pro.getValue().getAvailablequantity());
		});
	}
	public void searchProdutById() {
		System.out.println("Enter product id:");
		int id=sc.nextInt();
		Set<Map.Entry<Integer, Product>> entry = prolist.entrySet();
		entry.stream().filter(val->val.getValue().getProductid()==id).forEach(res->
		{
			System.out.println("product id:"+res.getValue().getProductid());
			System.out.println("product name is:"+res.getValue().getProdutname());
			System.out.println("product catagory is:"+res.getValue().getCatagory());
			System.out.println("product selling price is :"+res.getValue().getSellingPrice());
			System.out.println("product available quantity is :"+res.getValue().getAvailablequantity());
		});
	}
	public void searchProductByCatagory() {
		System.out.println("ENter catagory do you wnat to search:");
		String catgry=sc.next();
		Set<Map.Entry<Integer, Product>> pro = prolist.entrySet();
		pro.stream().filter(value->value.getValue().getCatagory().equals(catgry)).forEach(re->
		{
			System.out.println("************************************");
			System.out.println("product id:"+re.getValue().getProductid());
			System.out.println("product name is:"+re.getValue().getProdutname());
			System.out.println("product catagory is:"+re.getValue().getCatagory());
			System.out.println("product selling price is :"+re.getValue().getSellingPrice());
			System.out.println("product available quantity is :"+re.getValue().getAvailablequantity());
		});
	}
	public void searchByProductName() {
		System.out.println("Enter product name do u wnat to search:");
		String pname=sc.next();
		Set<Map.Entry<Integer, Product>> res = prolist.entrySet();
		res.stream().filter(re->re.getValue().getProdutname().equals(pname)).forEach(pro->
		{
			System.out.println("product id:"+pro.getValue().getProductid());
			System.out.println("product name is:"+pro.getValue().getProdutname());
			System.out.println("product catagory is:"+pro.getValue().getCatagory());
			System.out.println("product selling price is :"+pro.getValue().getSellingPrice());
			System.out.println("product available quantity is :"+pro.getValue().getAvailablequantity());
		});
	}
	public void totalCostProduct() {

		Set<Map.Entry<Integer, Product>> entry = prolist.entrySet();
		entry.stream().forEach(product->
		{
			totalcost+=product.getValue().getBuyingprice();
		});
		System.out.println("total cost of products is:"+totalcost);
	}
	public void ProfitByCatagory() {
		Set<Map.Entry<Integer, Product>> result = prolist.entrySet();
		result.stream().forEach(pro->
		{
			double profit=pro.getValue().getSellingPrice()-pro.getValue().getBuyingprice();
			System.out.println("profit for"+pro.getValue().getCatagory()+"is:"+profit);
		});
	}
	public void userDisplayList() {
		Set<Map.Entry<Integer, Product>> set = prolist.entrySet();
		set.stream().forEach(pro->
		{
			System.out.println("product Catagory is:"+pro.getValue().getCatagory());
			System.out.println("product name is:"+pro.getValue().getProdutname());
			System.out.println("product selling price is:"+pro.getValue().getSellingPrice());
			System.out.println("product available Quantity is:"+pro.getValue().getAvailablequantity());
		});
	}
	public void userSearchByCatagory() {
		System.out.println("Enter catagory which you want to search:");
		String catgy=sc.next();
		Set<Map.Entry<Integer, Product>> eset = prolist.entrySet();
		eset.stream().filter(val->val.getValue().getCatagory().equals(catgy)).forEach(pro->
		{
			System.out.println("product name is:"+pro.getValue().getItemname());
			System.out.println("product catagory is:"+pro.getValue().getCatagory());
			System.out.println("product selling price is :"+pro.getValue().getSellingPrice());
			System.out.println("product available quantity is :"+pro.getValue().getAvailablequantity());

		});
	}
	public void sortByPrice() {
		Set<Entry<Integer, Product>> entry = prolist.entrySet();
		entry.stream().sorted(new SortByPrice()).forEach(pr->
		{
			System.out.println("product name:"+pr.getValue().getProdutname());
			System.out.println("product selling price:"+pr.getValue().getSellingPrice());
			System.out.println("product catagory:"+pr.getValue().getCatagory());
			System.out.println("product quantity available:"+pr.getValue().getAvailablequantity());
		});
	}
}
