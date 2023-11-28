package com.project.menu;

import java.sql.SQLException;



public class MenuMain {
	public static void main(String[] args) {
		Menu main=new Menu();
		try {
			main.display();
		}  catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
