package ca.sheridan.eshop.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Map;

import ca.sheridan.eshop.model.ProductCatalogue;

public class AddItemService {
	public int insertItemToProductCatalogue(Map<String,String[]> parameterKeyValues) {
		ProductCatalogue newItem = new ProductCatalogue();
		int status = -1;
		Connection con;
		PreparedStatement statement = null;
		String query = "insert into ProductCatalogue values (?,?,?,?,?)";
		
		if(!parameterKeyValues.isEmpty()) { 
			//initialize the bean
			newItem.setCode(parameterKeyValues.get("code")[0]);
			newItem.setName(parameterKeyValues.get("name")[0]);
			newItem.setType(parameterKeyValues.get("type")[0]);
			double price = Double.parseDouble(parameterKeyValues.get("price")[0]);
			newItem.setPrice(price);
			boolean taxable = false;
			if(parameterKeyValues.get("taxable")[0].equalsIgnoreCase("yes"))
				taxable = true;
			newItem.setTaxable(taxable);
			
			//get db connection and insert item to db
			con = ConnectionManager.getConnection();
			try {
				statement = con.prepareStatement(query);
				statement.setString(1, newItem.getCode());
				statement.setString(2, newItem.getName());
				statement.setDouble(3, newItem.getPrice());
				statement.setBoolean(4, newItem.isTaxable());
				statement.setString(5, newItem.getType());
				status = statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					statement.close();
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return status;
	}

}
