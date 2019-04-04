package com.jdbcmysqldemo.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.jdbcmysqldemo.dao.ConnectionManager;
import com.jdbcmysqldemo.dao.JdbcConnectionManager;

import java.util.ArrayList;
import java.util.List;

public class GetCustomerNameFromDB {
	public static void main(String[] args) {
		for (Customers c : first10Customers())
			System.out.println(c.getCustomerName());
	}

	private static List<Customers> first10Customers() {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		// gets error property files not found
		// con = JdbcConnectionManager.getConnection();
		con = ConnectionManager.getConnection();
		Customers c;
		List<Customers> al = new ArrayList<Customers>();
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT customerNumber, customerName FROM customers LIMIT 10");
			System.out.println("First 10 Customer names");
			while (rs.next()) {
				c = new Customers();
				c.setCustomerNumber(rs.getInt(1));
				c.setCustomerName(rs.getString(2));
				al.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		finally {
			try {
				// closing resultset and statement
				rs.close();
				stmt.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return al;
	}
}
