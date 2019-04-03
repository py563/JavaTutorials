package com.jdbcmysqldemo.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcConnectionManager {
    private static String urlString;
    private static Connection con;

    public static Connection getConnection() {
    	Properties props = new Properties();
    	InputStream fis = null;

    	try {
    		fis = new FileInputStream("db-key.properties");
    		// load a properties file
    		props.load(fis);
    		Class.forName(props.getProperty("driverName"));
    		//fixing EDT error which made connection to database fail
    		urlString = props.getProperty("database") + props.getProperty("timezoneerrorfix");
    		//urlString = props.getProperty("database");
            con = DriverManager.getConnection(urlString, props.getProperty("username"), props.getProperty("password"));
        } catch (IOException e) {
			// TODO: handle exception
    		System.out.println("properties file not found");
		} catch (ClassNotFoundException ex) {
            // log an exception. for example:
            System.out.println("Driver not found."); 
        } catch (SQLException ex) {
            // log an exception. fro example:
        	ex.printStackTrace();
            System.out.println(ex.getCause().toString());
            System.out.println("Failed to create the database connection."); 
        }
        return con;
    }
}
