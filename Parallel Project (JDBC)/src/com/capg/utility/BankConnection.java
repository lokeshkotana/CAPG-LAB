package com.capg.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BankConnection {

	private static Connection con;
	static { //bcoz we want only one connection in whole project
		try {
			try {
				Class.forName("oracle.jdbc.OracleDriver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","lpu","hr");
			//System.out.println("Connected");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getonnection() {
		return con;
	}
	
}
