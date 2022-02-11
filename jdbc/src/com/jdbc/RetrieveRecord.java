package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class RetrieveRecord {
	//driver, connection, stmt, execute, close
	static String driver="com.mysql.jdbc.Driver";
	static Connection conn=null;
	static String dbURL="jdbc:mysql://localhost:3306/jdbc";
	static String username="root";
	static String password="root";

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

			Class.forName(driver);

			conn=DriverManager.getConnection(dbURL, username, password);

			PreparedStatement stmt=conn.prepareCall("select * from employee where employee_id=? and first_name=?");

			stmt.setInt(1,101);
			stmt.setString(2, "durga");

			ResultSet rs=stmt.executeQuery();
			if (rs==null) {
				System.out.println("the record is not found.");
			}

			if (rs.next()) {
				System.out.println(rs.getInt("employee_id")+" "+ rs.getString("first_name")+" "+ rs.getString("last_name")+" "+ rs.getFloat("salary"));
			}
		
			conn.close();
	}

}
