package com.jdbcmysqldemo.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbcmysqldemo.dao.ConnectionManager;
import com.jdbcmysqldemo.dao.JdbcConnectionManager;

public class GetCustomerNameFromDB {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		// gets error property files not found
		// con = JdbcConnectionManager.getConnection();		
		con = ConnectionManager.getConnection();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM customers LIMIT 10");
			System.out.println("First 10 Customer names");
			while (rs.next()) {
				System.out.println(rs.getString("customerName"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				//closing resultset and statement
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
