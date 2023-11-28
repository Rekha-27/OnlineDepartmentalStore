package com.jdbc.project.DAO;

import java.util.*;
import java.util.Scanner;
import java.sql.*;

import com.project.connect.DataConnect;
import com.project.pojo.User;
import com.project.service.ProductService;

public class UserDao {
	private List<User> ulist;
	private Connection con;
	private PreparedStatement stmt;
	private User user;
	private ProductService pservice;
	private Scanner sc;
	public UserDao() {
		sc=new Scanner(System.in);
		ulist=new ArrayList();
		con=DataConnect.getConnection();
		pservice=new ProductService();
	}
	public void userValidation() throws SQLException {
		boolean flag=false;
		stmt=con.prepareStatement("select * from user");
		ResultSet res = stmt.executeQuery();
		while(res.next()) {
			User u=new User();
			u.setUsername(res.getString(1));
			u.setPassword(res.getString(3));
			ulist.add(u);	
		}
		System.out.println("enter uer name:");
		String user=sc.next();
		System.out.println("enter user password:");
		String pass=sc.next();
		for(User u:ulist) {
			if(u.getUsername().equalsIgnoreCase(user) && u.getPassword().equalsIgnoreCase(pass)) {
				String ch="y";
				int choice=0;
				flag=true;
				while(ch.equalsIgnoreCase(ch)) {
					System.out.println("***************************************");
					System.out.println("1.list of products available in a store ");
					System.out.println("2.filter the products based on category");
					System.out.println("3.filter the products based on price");
					System.out.println("4.buy products");
					System.out.println("5.exit");
					System.out.println("Enter your choice:");
					choice=sc.nextInt();
					switch(choice) {
					case 1:
						pservice.userDisplayProduct();
						break;	
					case 2:
						pservice.searchByCatagory();
						break;
					case 3:
						pservice.filterPrice();
						break;
					case 4:
						pservice.customerBuyProduct(u.getUsername());
						break;
					case 5:
						break;
					}
					System.out.println("do you want to visit again userlist(y/n):");
					ch=sc.next();
				}
			}
			
		}
		if(flag==false) {
			System.out.println("enter valid user details");
		}
	}
}
