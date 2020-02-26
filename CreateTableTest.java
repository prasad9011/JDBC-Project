package com.prasad;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateTableTest {
	public static void main(String[] args) {
	Scanner sc = null;
	Connection con = null;
	Statement st = null;
	int count = 0;
	String sNo = null, tableName = null;
	String sName = null, sCourse = null, query = null;
	try {
		// Reading Input
		sc = new Scanner(System.in);
		if (sc != null) {
			System.out.println("Enter  table name");
			tableName = sc.next();
			System.out.println("Enter 1st column name");
			sNo = sc.next();
			System.out.println("Enter 2nd column name");
			sName = sc.next();
			System.out.println("Enter 3rd column name");
			sCourse = sc.next();
		} // if
		
			// Register Driver
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		// Create Connection obj
		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "system");
		
		// Create Statement obj
		if (con != null)
			st = con.createStatement();
		
		// prepare query
		// CREATE TABLE TEST(SNO NUMBER(10),SNAME VARCHAR2(10),SCOURSE VARCHAR2(20))
		query = "CREATE TABLE " + tableName + " (" + sNo + "  number(10)," + sName + "  VARCHAR2(10)," + sCourse
				+ " VARCHAR2(10))";
		
		// execute query
		if (st != null)
			count = st.executeUpdate(query);
		if (count == 0)
			System.out.println("Table  Created");
		else
			System.out.println("Table not created");
		
	} // try
	catch (SQLException se) {// Known Exception
		se.printStackTrace();
	} catch (ClassNotFoundException cnf) {// known Exception
		cnf.printStackTrace();
	} catch (Exception e) {// unknown Exception
		e.printStackTrace();
		
	} finally {
		// close objects

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

	}

}
}
