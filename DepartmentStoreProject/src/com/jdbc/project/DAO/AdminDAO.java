package com.jdbc.project.DAO;
import java.sql.*;
import com.project.service.*;
import java.util.*;

import com.project.connect.DataConnect;
import com.project.pojo.User;
public class AdminDAO {
	private Scanner sc;
	private Connection con;
	private PreparedStatement stmt;
	private List<User> ulist;
	private ProductService pservice;
	private AdminService service;
	public AdminDAO() {
		con=DataConnect.getConnection();
		sc=new Scanner(System.in);
		pservice=new ProductService();
		ulist=new ArrayList();
	}
	public void Registration() throws SQLException {
		stmt=con.prepareStatement("insert into user values(?,?,?,?,?)");
			System.out.println("enter user name:");
			stmt.setString(1,sc.next());
			System.out.println("enter email id:");
			stmt.setString(2,sc.next());
			System.out.println("enter password:");
			stmt.setString(3,sc.next());
			stmt.setInt(4,100);
			System.out.println("enter user type:");
			stmt.setString(5,sc.next());
			stmt.addBatch();
		
		int[] res = stmt.executeBatch();
		if(res[0]>0) {
			System.out.println("user successfully inserted");
		}
		else {
			System.out.println("user not inserted");
		}
	}
	
	public void Adminvalidate() throws SQLException {
		boolean flag=false;
		stmt=con.prepareStatement("select * from user");
		ResultSet res = stmt.executeQuery();
		while(res.next()) {
			User u=new User();
			u.setUsername(res.getString(1));
			u.setPassword(res.getString(3));
			u.setUsertype(res.getString(5));
			ulist.add(u);
		}
		System.out.println("enter admin name:");
		String a_name=sc.next();
		System.out.println("enter admin password:");
		String a_pass=sc.next();
		for(User u:ulist) {
			if(u.getUsername().equalsIgnoreCase(a_name) && u.getPassword().equalsIgnoreCase(a_pass) && u.getUsertype().equalsIgnoreCase("Admin")) {
				System.out.println("successfully login");
				flag=true;
				System.out.println("Welcome "+u.getUsername());
				String choice="y";
				int ch=0;
				while(choice.equals("y")) {
					System.out.println("**********************************************");
					System.out.println("1.List of products in a store");
					System.out.println("2.Search product using productid:");
					System.out.println("3.list of products by catagory:");
					System.out.println("4.search the product by using productname");
					System.out.println("5.check the total cost of products ");
					System.out.println("6.display profit amount based on catagory ");
					System.out.println("7.Add a product to store ");
					System.out.println("8.diplay product based on price");
					System.out.println("9.exit");
					System.out.println("************************************************");
					System.out.println("Enter your choice:");
					ch=sc.nextInt();
					switch(ch) {
					case 1:
						pservice.display();
						break;
					case 2:
						pservice.searchById();
						break;
					case 3:
						pservice.searchByCatagory();
						break;
					case 4:
						pservice.searchByName();
						break;
					case 5:
						pservice.totalCost();
						break;
					case 6:
						pservice.profitcatagory();
						break;
					case 7:
						pservice.addProductAdmin();
						break;
					case 8:
						pservice.filterPrice();
						break;
					case 9:
						System.exit(0);
						break;
					}
					System.out.println("*****************************************");
					System.out.println("do you want to continue(y/n):");
					choice=sc.next();
				}
			}
			
		}
		if(flag==false) {
			System.out.println("enter valid  admin details");
		}
	}
	
}
