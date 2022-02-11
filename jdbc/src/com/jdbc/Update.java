package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
	static String driver="com.mysql.jdbc.Driver";
	static Connection conn=null;
	static String dbURL="jdbc:mysql://localhost:3306/jdbc";
	static String usr="root";
	static String psw="root";
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		//driver
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			//connecting database and java
			conn=DriverManager.getConnection(dbURL, usr, psw);
			if(conn!=null) {
				System.out.println("database connected successfully.");
			}else {
				System.out.println("data connection failed.");
				System.exit(0);
			}
			
			//query
			PreparedStatement ps=conn.prepareCall("update employee set last_name=?,email=? where email=?" );
			ps.setString(1, "subba");
			ps.setString(2, "ns@gmail");
			ps.setString(3, "nm@gmail.com");
			
			//execute
			int i=ps.executeUpdate();
			if(i>0) {
				System.out.println("record updated successfully.");
			}else {
				System.out.println("updated failed.");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		

	}

}
