package com.project.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class getconnection {
	public static Connection connect1()
	{
		Connection conn = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/delta_jsp", "root", "Pass@12345");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

}
