package com.jdbc.project.DAO;

import java.sql.*;
import java.util.*;

import com.project.connect.DataConnect;
import com.project.pojo.*;

public class ProductDAO {
	private Scanner sc;
	private Connection con;
	private PreparedStatement stmt;
	private PreparedStatement stmt1;
	private List<Product> plist;
	private List<Purchase>blist;
	public ProductDAO() {
		sc = new Scanner(System.in);
		plist = new ArrayList();
		con = DataConnect.getConnection();
	}

	public void addProduct(List<Product> plist, List<Item> ilist) throws SQLException {
		stmt = con.prepareStatement("insert into product values(?,?,?,?,?,?,?)");
		stmt1 = con.prepareStatement("insert into Item values(?,?,?)");
		for (Product p : plist) {
			stmt.setInt(1, p.getProductid());
			stmt.setString(2, p.getProdutname());
			stmt.setDouble(3, p.getSellingPrice());
			stmt.setInt(4, p.getAvailablequantity());
			stmt.setString(5, p.getItemname());
			stmt.setString(6, p.getCatagory());
			stmt.setDouble(7, p.getBuyingprice());
			stmt.addBatch();
		}
		int[] res = stmt.executeBatch();
		if (res[0] > 0) {
			System.out.println(" Product Successfully inserted");
		} else {
			System.out.println("product not inserted");
		}
		for (Item i : ilist) {
			stmt1.setString(1, i.getItemname());
			stmt1.setString(2, i.getCatagory());
			stmt1.setDouble(3, i.getBuyingprice());
			stmt1.addBatch();
		}
		int[] resu = stmt1.executeBatch();
		if (resu[0] > 0) {
			System.out.println("item Successfully inserted");
		} else {
			System.out.println("item not inserted");
		}
	}

	public void displayAdminProduct() throws SQLException {
		System.out.println("*****************************************************************");
		stmt = con.prepareStatement("select * from product");
		ResultSet res = stmt.executeQuery();
		while (res.next()) {
			System.out.println("product id is                              :" + res.getInt(1));
			System.out.println("product name is                            :" + res.getString(2));
			System.out.println("product catagory is                        :" + res.getString(6));
			System.out.println("product selling price is                   :" + res.getDouble(3));
			System.out.println("product avaliable quantity is              :" + res.getInt(4));
			System.out.println("product buying price is                    :" + res.getDouble(7));
		}
		System.out.println("*********************************************************************");
	}

	public void displayUserProduct() throws SQLException {
		
		System.out.println("*********************************************************************");
		stmt = con.prepareStatement("select * from product");
		ResultSet res = stmt.executeQuery();
		while (res.next()) {
			
			System.out.println("product id is                       :" + res.getInt(1));
			System.out.println("product name is                     :" + res.getString(2));
			System.out.println("product catagory is                 :" + res.getString(6));
			System.out.println("product selling price is            :" + res.getDouble(3));
			System.out.println("product avaliable quantity is       :" + res.getInt(4));
		}
		System.out.println("*********************************************************************");
		
	}

	public void SearchByProductId() throws SQLException {
		boolean flag=false;
		System.out.println("*******************************************************************");
		System.out.println("Enter product id:");
		int p_id = sc.nextInt();
		stmt = con.prepareStatement("select * from product where product_id =?");
		stmt.setInt(1, p_id);
		ResultSet result = stmt.executeQuery();
		while (result.next()) {
			flag=true;
			System.out.println("product id                            :" + result.getInt(1));
			System.out.println("product name is                       :" + result.getString(2));
			System.out.println("product catagory is                   :" + result.getString(6));
			System.out.println("product selling price is              :" + result.getDouble(3));
			System.out.println("product available quantity is         :" + result.getInt(4));
		}
		System.out.println("*******************************************************************");
		if(flag==false) {
			System.out.println("enter valid product id");
		}
	}

	public void searchProductByCatagory() throws SQLException {
		boolean flag=false;
		System.out.println("*******************************************************************");
		System.out.println("enter catagory name:");
		String cat = sc.next();
		stmt = con.prepareStatement("select * from product where catagory=?");
		stmt.setString(1, cat);
		ResultSet res = stmt.executeQuery();
		while (res.next()) {
			flag=true;
			System.out.println("product id is                            :" + res.getInt(1));
			System.out.println("product name is                          :" + res.getString(2));
			System.out.println("product selling price is                 :" + res.getDouble(3));
			System.out.println("product available quantity is            :" + res.getInt(4));
		}
		System.out.println("******************************************************************");
		if(flag==false) {
			System.out.println("enter valid catagory name");
		}
	}

	public void searchByProductName() throws SQLException {
		System.out.println("****************************************************************");
		System.out.println("enter Product name:");
		String name = sc.next();
		boolean flag=false;
		stmt = con.prepareStatement("select * from product where product_name=?");
		stmt.setString(1, name);
		ResultSet re = stmt.executeQuery();
		while (re.next()) {
			flag=true;
			System.out.println("product id is                      :" + re.getInt(1));
			System.out.println("product catagory is                :" + re.getString(6));
			System.out.println("product selling price is           :" + re.getDouble(3));
			System.out.println("product available quantity is      :" + re.getInt(4));
		}
		System.out.println("*****************************************************************");
		if(flag==false) {
			System.out.println("enter valid product id");
		}
	}

	public void totalCostProduct() throws SQLException {
		double total=0.0;
		stmt = con.prepareStatement("select * from product");
		ResultSet res = stmt.executeQuery();
		if (res.next()) {
			total+=res.getDouble(7)*res.getInt(4);
		}
		System.out.println("*********************************************");
		System.out.println("total money sept on buying products is "+total);
		System.out.println("**********************************************");
	}

	public void filterByprice() throws SQLException {
		System.out.println("enter a price which you get a order list :");
		double selling = sc.nextDouble();
		stmt = con.prepareStatement("select * from product where selling_price>=?");
		stmt.setDouble(1, selling);
		ResultSet res = stmt.executeQuery();
		while (res.next()) {
			System.out.println("****************************************************");
			System.out.println("product id                    :" + res.getInt(1));
			System.out.println("product name is               :" + res.getString(2));
			System.out.println("product catagory is           :" + res.getString(6));
			System.out.println("product selling price is      :" + res.getDouble(3));
			System.out.println("product available quantity is :" + res.getInt(4));
		}
	}
	public void billGenerator(String username,List<Purchase> blist) throws SQLException {
		double total_price=0.0;
		if(!blist.isEmpty()) {
		System.out.println("*******************BILL***********************************");
		System.out.println("*******************" + username+"***********************");
		for(Purchase res:blist) {
			System.out.println("product _name             :" + res.getProductname());
			System.out.println(" product_quantity is      :" + res.getQuantity());
			System.out.println("each product bill is      : " + res.getProductbill());
			total_price += res.getProductbill();
		}
		System.out.println("total price of all products is :" + total_price);
		System.out.println("*********************************************************");
		}
	}

	public void ProfitByCatagory() throws SQLException {
		double total=0.0;
		double selling=0.0;
		double buying=0.0;
		System.out.println("************************************************");
		stmt = con.prepareStatement("select * from product");
		ResultSet res = stmt.executeQuery();
		while (res.next()) {
			selling+=res.getDouble(3)*res.getInt(4);
			buying+=res.getDouble(7)*res.getInt(4);
			total=selling-buying;
			System.out.println("profit for"+res.getString(6)+"catagory is:"+total);
		}
		System.out.println("******************************************************");
	}
	public void updatePrices(String productname,int quantity) throws SQLException {
		stmt=con.prepareStatement("update product set  available_quantity= available_quantity-? where product_name=? ");
		stmt.setInt(1, quantity);
		stmt.setString(2, productname);
		int update = stmt.executeUpdate();
		if(update>0) {
			System.out.println("updated product details");
		}
	}

	public void buyProduct(String username) throws SQLException {
		String productname="";
		int t=0;
		displayUserProduct();
		String ch="y";
		blist=new ArrayList();
		while(ch.equalsIgnoreCase("y")) {
			System.out.println("enter product name:");
		    productname=sc.next();
			System.out.println("how much quantity products do you want:");
			int quantity=sc.nextInt();
			stmt = con.prepareStatement("select * from product where product_name=?");
			stmt.setString(1, productname);
			ResultSet res = stmt.executeQuery();
			if(res.next()) {				
				if (quantity<=res.getInt(4) && res.getString(2).equalsIgnoreCase(productname)) {
					
					Purchase p=new Purchase();
					PreparedStatement stmt1 = con.prepareStatement("insert into Customer(u_name,product_name,quantity,productbill) values(?,?,?,?)");
					p.setUsername(username);
					p.setProductname(productname);
					p.setQuantity(t+quantity);
					p.setProductbill(res.getDouble(3)*quantity);
					blist.add(p);
					stmt1.setString(1, username);
					stmt1.setString(2, productname);
					stmt1.setInt(3, quantity);
					stmt1.setDouble(4, (res.getDouble(3)*quantity));
					int update = stmt1.executeUpdate();
					
					if(update>0) {
						System.out.println("updated");
					}
					updatePrices(productname,quantity);
				}
			}
			System.out.println("do you want to buy products again(y/n):");
			ch=sc.next();	
		}
		displayProductBill(username,blist);
	}
	public void displayProductBill(String username,List<Purchase> blist1) throws SQLException {
		double total_price=0.0;
		 stmt1 = con.prepareStatement("select * from user where u_name=?");
		stmt1.setString(1, username);
		ResultSet res1 = stmt1.executeQuery();
		System.out.println("do you want to use supercoins(y/n):");
		String s=sc.next();
		if(s.equalsIgnoreCase("y")) {
			
			if(res1.next()) {
				
				if(res1.getInt(4)>0) {
					
					int discount = res1.getInt(4) / 20;
					stmt=con.prepareStatement("update user set u_supercoins=u_supercoins-? where u_name=?");
					stmt.setInt(1, discount*20);
					stmt.setString(2,username);
					int update = stmt.executeUpdate();
					if(update>0) {
						System.out.println("After using supercoins available supercoins are:"+res1.getInt(4));
					}
					
					if(!blist1.isEmpty()) {
					System.out.println("*******************BILL*********************************");
					System.out.println("*******************" + username+"***********************");
					for(Purchase res:blist1){
						System.out.println("product _name             :" + res.getProductname());
						System.out.println(" product_quantity is      :" + res.getQuantity());
						System.out.println("each product bill is      : " + res.getProductbill());
						total_price += res.getProductbill();

					}
					System.out.println("total price of all products is :" + (total_price - discount));
					System.out.println("************************************************************");
					}
				}
				else {
					System.out.println("insufficient supercoins......");
					billGenerator(username,blist1);
				}
			}
		}
		else {
			billGenerator(username,blist);
		}
	}

}