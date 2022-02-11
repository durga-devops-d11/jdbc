package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FetchRecordAll {
	
	static String driver="com.mysql.jdbc.Driver";
	static String dbURL="jdbc:mysql://localhost:3306/jdbc";
	static Connection conn=null;
	static String username="root";
	static String password="root";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//loading driver class
		Class.forName("com.mysql.jdbc.Driver");
		
		//creating connection
		conn=DriverManager.getConnection(dbURL, username, password);
		
		//creating statement
		PreparedStatement ps=conn.prepareStatement("select * from employee");
		
		//execute the code
		ResultSet rs=ps.executeQuery();

		while(rs.next()) {
			System.out.println(rs.getInt("employee_id")+ " "+ rs.getString("first_name")+" "+rs.getString("last_name")+" "+rs.getString("email"));
		}
		
		//close connection
		conn.close();

	}

}
