package com.prasad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Delete_Test {
	public static void main(String[] args) {
		Scanner sc = null;
		Connection con = null;
		Statement st = null;
		int no = 0;
		int result = 0;
		try {

			// Read inputs
			sc = new Scanner(System.in);
			System.out.println("Enter Student no to delete");
			no = sc.nextInt();

			// Register JDBC driver s/w
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// Establish the connection
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "system");

			// create Statement objects
			if (con != null)
				st = con.createStatement();

			// send and execute SQL Query in DB s/w
			if (st != null)
				result = st.executeUpdate("delete from student where sno=" + no);

			// process the result
			if (result == 0)
				System.out.println("No records found for deletion");
			else
				System.out.println(result + "no.of  record are found for deletion");
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

