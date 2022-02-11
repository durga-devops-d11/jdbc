package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Delete {
	static String driver="com.mysql.jdbc.Driver";
	static Connection conn=null;
	static String dbURL="jdbc:mysql://localhost:3306/xyz_company";
	static String usr="root";
	static String psw="root";

	public static void main(String[] args) {
		
		try {
			Class.forName(driver);
		
			//connection
			conn=DriverManager.getConnection(dbURL, usr, psw);
			if(conn!=null) {
				System.out.println("database is connected successfully");
			}
				//query
				PreparedStatement ps=conn.prepareCall("delete from employee where id=?");
				ps.setInt(1, 104);
				
				//execute
				int i=ps.executeUpdate();
				if (i>0) {
					System.out.println("successfully deleted.");
				}else {
					System.out.println("record not found.");
				}
			}
			
			catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
