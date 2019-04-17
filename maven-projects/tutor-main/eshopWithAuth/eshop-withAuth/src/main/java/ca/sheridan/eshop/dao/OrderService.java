package ca.sheridan.eshop.dao;

import java.util.List;

import ca.sheridan.eshop.model.ProductCatalogue;

public class OrderService {
	public double getOrderedItemTotal(List<ProductCatalogue> orderedItems) {
		double totalAmount = 0.0;
		for(ProductCatalogue orderedItem : orderedItems) {
			totalAmount += orderedItem.getPriceWithTax();
		}
		return totalAmount;
	}
}
