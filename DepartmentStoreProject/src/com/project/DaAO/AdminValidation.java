package com.project.DaAO;

import com.project.pojo.Admin;
import java.util.*;
public class AdminValidation {
	private AdminUserOperations auoperation;
	private Admin admin;
	private Scanner sc;
	public AdminValidation() {
		auoperation=new AdminUserOperations();
		sc=new Scanner(System.in);
	}
	
	public void adminValidation() {
		admin=new Admin();
		admin.setAdminname("admin");
		admin.setAdminpswd("admin");
		System.out.println("enter adminname:");
		String owner=sc.next();
		System.out.println("enter admin password:");
		String ownerpswd=sc.next();
		if(owner.equals(admin.getAdminname()) && ownerpswd.equals(admin.getAdminpswd())) {
			System.out.println("successfully login");
			System.out.println("Welcome "+admin.getAdminname());
			String choice="y";
			int ch=0;
			while(choice.equals("y")) {
				System.out.println("*********************************************8");
				System.out.println("1.List of products in a store");
				System.out.println("2.Search product using productid:");
				System.out.println("3.list of products by catagory:");
				System.out.println("4.search the product by using productname");
				System.out.println("5.check the total cost of products ");
				System.out.println("6.display profit amount based on catagory ");
				System.out.println("7.Add a product to store ");
				System.out.println("Enter your choice:");
				ch=sc.nextInt();
				switch(ch) {
				case 1:
					auoperation.display();
					auoperation.displayProducts();
					break;
				case 2:
					auoperation.searchProdutById();
					break;
				case 3:
					auoperation.searchProductByCatagory();
					break;
				case 4:
					auoperation.searchByProductName();
					break;
				case 5:
					auoperation.totalCostProduct();
					break;
				case 6:
					auoperation.ProfitByCatagory();
					break;
				case 7:
					auoperation.addProductAdmin();
					break;
				}
				System.out.println("do you want to continue(y/n):");
				choice=sc.next();
			}
		}
		else {
			System.out.println("ENter valid admin details");
		}
	}
}
