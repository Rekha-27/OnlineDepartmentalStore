package com.project.menu;
import java.sql.SQLException;
import java.util.*;

import com.jdbc.project.DAO.*;
//import com.project.exception.UserInvalidException;
import com.project.service.AdminService;
//import com.project.service.ProductServices;
public class Menu {
	private Scanner scan;
//	private ProductServices pdtservice;
	private AdminService aservice;
	private UserDao userdao;
	public Menu() {
		scan=new Scanner(System.in);
		aservice=new AdminService();
		userdao=new UserDao();
	}
	public void display() throws  SQLException {
		String choice="y";
		int ch=0;
		while(choice.equals("y")) {
			System.out.println("1.login as Admin:");
			System.out.println("2.login as User");
			System.out.println("3.Register");
			System.out.println("4.exit");
			System.out.println("enter your choice:");
			ch=scan.nextInt();
			switch(ch) {
			case 1:
				aservice.adminValidation();
				break;
			case 2:
				userdao.userValidation();
				break;
			case 3:
				aservice.Registor();
				break;
			case 4:
				System.exit(0);
				break;
			}
			System.out.println("do you want to continue (y/n):");
			choice=scan.next();
		}
	}
}
