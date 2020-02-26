package com.prasad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Update_Test {

public static void main(String[] args) {
	Scanner sc = null;
	Connection con = null;
	Statement st = null;
	int no = 0;
	String NewName = null, NewAddrs = null;
	String query = null;
	int count = 0;
	try {

		// Read inputs
		sc = new Scanner(System.in);
		if (sc != null) {
			System.out.println("Enter Existing Student Number to update");
			no = sc.nextInt();
			System.out.println("Enter new Name for Student");
			NewName = sc.next();
			System.out.println("Enter address:");
			NewAddrs = sc.next();
		} // if

		// Convert input values as required for the SQL Query
		NewName = "'" + NewName + "'";
		NewAddrs = "'" + NewAddrs + "'";

		// Register JDBC driver s\w (optional)
		Class.forName("oracle.jdbc.driver.OracleDriver");

		// establish the connection
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "system");

		// create Statement object
		if (con != null)
			st = con.createStatement();

		// prepare SQL query
		query = "update student set name=" + NewName + ",sadd=" + NewAddrs + "where sno=" + no;
		System.out.println(query);

		// send and execute SQL Query to DB S/w
		if (st != null)
			count = st.executeUpdate(query);

		// process the result
		if (count == 0)
			System.out.println("Record not found to update");
		else
			System.out.println("Record  found to update");
	} // try

	catch (SQLException se) {// Known Exception
		se.printStackTrace();
	} catch (ClassNotFoundException cnf) {// known Exception
		cnf.printStackTrace();
	} catch (Exception e) {// unknown Exception
		e.printStackTrace();
	}

	finally {
		// close JDBC objects

		try {
			if (st != null)
				st.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			if (con != null) 
				con.close();
		} catch (SQLException se) {
			se.printStackTrace();
		}
		try {
			if (sc != null)
				sc.close();
		} catch (Exception se) {
			se.printStackTrace();
		}
	} // finally
}// main
}// class
