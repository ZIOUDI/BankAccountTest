package com.bank.spi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public interface H2_ConnexionRepo {

	// JDBC driver name and database URL
	static final String JDBC_DRIVER = "org.h2.Driver";
	static final String DB_URL = "jdbc:h2:~/test";

	// Database credentials
	static final String USER = "sa";
	static final String PASS = "";

	public static  ResultSet javaRepo(String QUERY) {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =null;

		try {
			// STEP 1: Register JDBC driver
			Class.forName(JDBC_DRIVER);

		 
			conn = DriverManager.getConnection(DB_URL, USER, PASS);
 
			stmt = conn.createStatement();
			stmt.executeUpdate(QUERY);
			rs = stmt.executeQuery(QUERY);

			while (rs.next()) {
				System.out.print("ID: " + rs);

			}
 
			stmt.close();
			conn.close();
		} catch (SQLException se) { // Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) { // Handle errors for Class.forName
			e.printStackTrace();
		} finally { // finally block used to close resources
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException se2) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
		System.out.println(" java Repo END !!!!!!");
		return rs;
	}

}
