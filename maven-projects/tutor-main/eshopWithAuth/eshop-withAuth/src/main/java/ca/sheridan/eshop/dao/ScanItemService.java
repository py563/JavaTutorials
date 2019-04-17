package ca.sheridan.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
}
