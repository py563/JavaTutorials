package ca.sheridan.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import ca.sheridan.eshop.model.ProductCatalogue;

public class ScanItemService {
	public ProductCatalogue getScannedItem(String itemCode) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;

		connection = ConnectionManager.getConnection();
		ProductCatalogue item = null;

		try {
			String query = "select * from ProductCatalogue where code =?";
			statement = connection.prepareStatement(query);
			statement.setString(1, itemCode);
			resultSet = statement.executeQuery();

			while (resultSet.next()) {
				item = new ProductCatalogue();
				item.setCode(resultSet.getString(1));
				item.setName(resultSet.getString(2));
				item.setPrice(resultSet.getDouble(3));
				//change order 4-5
				item.setType(resultSet.getString(5));
				item.setTaxable(resultSet.getBoolean(4));
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// closing result set and statement
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return item;
	}

	public int insertOrder(Map<String, String[]> parameterMap) {
		// TODO Auto-generated method stub
		int status = -1;
		String query = "insert into PurchaseOrder values (?,?,?)";
		Connection connection = null;
		PreparedStatement statement = null;
		// GET db connection
		connection = ConnectionManager.getConnection();
		
		try {
		statement = connection.prepareStatement(query);
		statement.setString(1, parameterMap.get("custName")[0]);
		statement.setString(2, parameterMap.get("custEmail")[0]);
		statement.setDouble(3,Double.parseDouble(parameterMap.get("totalAmount")[0]));
		status = statement.executeUpdate();
		System.out.println("order inserted Status: "+status);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// closing result set and statement
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return status;
	}
}
