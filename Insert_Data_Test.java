package com.prasad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Insert_Data_Test {

	public static void main(String[] args) {
		Scanner sc = null;
		Connection con = null;
		Statement st = null;
		int no = 0;
		int result = 0;
		String name = null, addrs = null;

		try {
			// read inputs
			sc = new Scanner(System.in);
			if (sc != null) {
				System.out.println("Enter Student Id::");
				no = sc.nextInt();
				System.out.println("Enter Student name::");
				name = sc.next();
				System.out.println("Enter Student Address::");
				addrs = sc.next();

			} // if

			// convert input values as required foe the SQL query
			name = "'" + name + "'";
			addrs = "'" + addrs + "'";

			// register JDBC driver
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// Establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "system");
			System.out.println("Connection Sucessfull");

			// create JDBC STatement object
			if (con != null)
				st = con.createStatement();
			
			// prepare SQL Query
			String query = "insert into student values(" + no + "," + name + "," + addrs + ")";
			System.out.println("query");

			// send & execute the Query in db s/w
			if (st != null) {
				result = st.executeUpdate(query);
			}
			// process the Reuslt
			if (result == 0)
				System.out.println("Record not inserted");
			else
				System.out.println("Record inserted");
		} // try
		catch (SQLException se) {
			se.printStackTrace();
		} catch (ClassNotFoundException cnf) {
			cnf.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// close JDBC objs
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
			} catch (Exception e) {
				e.printStackTrace();
			}
		} // finally
	}// main
}// class
