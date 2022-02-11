package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Insert {
	//loading a  driver class->create a connection->create a stmt->execute the stmt->close the connection
	
	static String driver="com.mysql.jdbc.Driver";
	static Connection conn=null;
	static String dbURL="jdbc:mysql://localhost:3306/jdbc";
	static String username="root";
	static String password="root";

	public static void main(String[] args) {
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(dbURL, username, password);
			PreparedStatement ps=conn.prepareStatement("insert into employee values(?,?,?,?,?)");
			ps.setInt(1,101);
			ps.setString(2,"durga");
			ps.setString(3, "maharjan");
			ps.setString(4,"durgamaharjan2011@gmail.com");
			ps.setFloat(5, (float) 4000.0);
			
			int rows=ps.executeUpdate();
			if (!(rows<0)) {
				System.out.println("data has been inserted successfully.");
			}else {
				System.out.println("no data inserted.");
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
