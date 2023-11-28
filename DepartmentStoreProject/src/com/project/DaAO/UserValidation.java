package com.project.DaAO;

import java.util.*;
import java.util.Scanner;

//import com.project.exception.UserInvalidException;
import com.project.pojo.*;

public class UserValidation {
	private User user;
	private Admin admin;
	private Scanner sc;
	//private UserInvalidException uiex;
	private AdminUserOperations auoperation;
	private Map<Integer,User>usermap;
	public UserValidation() {
		sc=new Scanner(System.in);
		usermap=new HashMap<>();
		auoperation=new AdminUserOperations();
		//uiex=new UserInvalidException();
	}
	public void registration() {
		user=new User();
		int id=1;
		System.out.println("Enter username:");
		user.setUsername(sc.next());
		System.out.println("enter email:");
		user.setEmailid(sc.next());
		System.out.println("Enter password");
		user.setPassword(sc.next());
		int coin=100;
		user.setSupercoins(coin);
		System.out.println("new user gets a 100 superoins");
		usermap.put(id, user);
		id++;
	}
	public void userValidation() //throws //UserInvalidException
	{
		System.out.println("Enter username:");
		String uname=sc.next();
		System.out.println("Enetr password:");
		String pswd=sc.next();
		if(uname.equals(user.getUsername()) && pswd.equals(user.getPassword())){
			System.out.println("login successfully......");
			System.out.println("wwelcome "+user.getUsername());
			String choice="y";
			int ch=0;
			while(choice.equals("y")) {
				System.out.println("*******************************************");
				System.out.println("1. Display list of products");
				System.out.println("2.allow customer new registration and login to view product");
				System.out.println("3.search product based on catagory");
				System.out.println("4.search product based on price");
				System.out.println("Enter your choice:");
				ch=sc.nextInt();
				switch(ch) {
				case 1:
					auoperation.display();
					auoperation.userDisplayList();
					break;
				case 2:registration();
					break;
				case 3:auoperation.userSearchByCatagory();
					break;
				case 4:auoperation.sortByPrice();
					break;
				}
				System.out.println("do you wnat to continue(y/n):");
				choice=sc.next();
			}
		}
		else {
//			throw uiex;
		}
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
