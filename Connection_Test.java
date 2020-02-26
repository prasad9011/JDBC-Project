package com.prasad;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connection_Test {
	public static void main(String[] args) throws Exception {

		Connection con = null;
		
		// register JDBC driver
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// establish the connection
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "system");
		
		// verify the connection
		if (con == null)
			System.out.println("Connection is not establish");
		else
			System.out.println("Connection is  establish");
	}
}
