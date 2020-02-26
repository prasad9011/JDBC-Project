package com.prasad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Select_Test {

	public static void main(String[] args) throws Exception {
		Connection con = null;
		Statement st = null;
		
		
		// Resgister JDBC driver 
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// establish the connection
		 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "system");
		// create Statement object
		 st = con.createStatement();
		// send and execute SQL Query in DB s\w
		ResultSet rs = st.executeQuery("SELECT * FROM DEPT");
		// process the ResultSet Object
		while (rs.next() != false) {
			System.out.println(rs.getInt(1) + " " + rs.getString(2) + "  " + rs.getString(3));
		}
		System.out.println("jdbc con obj class name::" + con.getClass());
		System.out.println("jdbc st obj class name::" + st.getClass());
		System.out.println("jdbc rs obj class name::" + rs.getClass());
		// close JDBC object
		rs.close();
		st.close();
		con.close();
	}
}
