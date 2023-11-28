package com.project.pojo;

import java.util.Map;

public class User {
	private String username;
	private String emailid;
	private String password;
	private int supercoins;
	private String usertype;
	public String getUsertype() {
		return usertype;
	}
	public void setUsertype(String usertype) {
		this.usertype = usertype;
	}
	private Map<Integer,User>usermap;
	public Map<Integer, User> getUsermap() {
		return usermap;
	}
	public void setUsermap(Map<Integer, User> usermap) {
		this.usermap = usermap;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getSupercoins() {
		return supercoins;
	}
	public void setSupercoins(int supercoins) {
		 this.supercoins = supercoins;
	}
	
}
