package ca.sheridan.eshop.model;

public class ProductCatalogue {
	private String code;
	private String name;
	private double price;
	private String type;
	private boolean taxable;
	
	public ProductCatalogue(String code, String name, double price, String type, boolean taxable) {
		this.code = code;
		this.name = name;
		this.price = price;
		this.type = type;
		this.taxable = taxable;
	}
	
	public ProductCatalogue() {
		
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isTaxable() {
		return taxable;
	}

	public void setTaxable(boolean taxable) {
		this.taxable = taxable;
	}

	// Calculates tax if item is taxable
	public double getTaxable() {
		if(isTaxable()) {
			return (getPrice() * 13)/100;
		}
		return 0.00;
	}
	
	// Adds Taxes to price
	public double getPriceWithTax() {
		if(isTaxable()) {
			return price + getTaxable();
		}
		return price;
	}

}
