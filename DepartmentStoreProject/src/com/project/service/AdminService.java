package com.project.service;
import java.sql.SQLException;
import java.util.*;

import com.jdbc.project.DAO.*;
import com.jdbc.project.DAO.*;
import com.project.pojo.*;
public class AdminService {
	private Scanner sc;
	private List<User> ulist;
	private List<Product> plist;
	private List<Item> ilist;
	private AdminDAO admindao;
	private ProductService pservice;
	public AdminService() {
		ulist=new ArrayList();
		
		sc=new Scanner(System.in);
		admindao=new AdminDAO(); 
		pservice=new ProductService();
		
	}
	public void Registor() throws SQLException {
		
		admindao.Registration();
	}
	public void adminValidation() throws SQLException {
		
				admindao.Adminvalidate();
	}
	
}
