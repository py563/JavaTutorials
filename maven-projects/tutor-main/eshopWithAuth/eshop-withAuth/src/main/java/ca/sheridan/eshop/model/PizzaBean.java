package ca.sheridan.eshop.model;

import java.util.ArrayList;

public class PizzaBean {
private String customerName;
private String selectedCrust;
private String selectedSauce;
private ArrayList<String> selectedTopins;
private ArrayList<String> selectedTopinsImages;
/**
 * @return the customerName
 */
public String getCustomerName() {
	return customerName;
}
/**
 * @param customerName the customerName to set
 */
public void setCustomerName(String customerName) {
	this.customerName = customerName;
}
/**
 * @return the selectedCrust
 */
public String getSelectedCrust() {
	return selectedCrust;
}
/**
 * @param selectedCrust the selectedCrust to set
 */
public void setSelectedCrust(String selectedCrust) {
	this.selectedCrust = selectedCrust;
}
/**
 * @return the selectedSauce
 */
public String getSelectedSauce() {
	return selectedSauce;
}
/**
 * @param selectedSauce the selectedSauce to set
 */
public void setSelectedSauce(String selectedSauce) {
	this.selectedSauce = selectedSauce;
}
/**
 * @return the selectedTopins
 */
public ArrayList<String> getSelectedTopins() {
	return selectedTopins;
}
/**
 * @param selectedTopins the selectedTopins to set
 */
public void setSelectedTopins(ArrayList<String> selectedTopins) {
	this.selectedTopins = selectedTopins;
}
/**
 * @return the selectedTopinsImages
 */
public ArrayList<String> getSelectedTopinsImages() {
	return selectedTopinsImages;
}
/**
 * @param selectedTopinsImages the selectedTopinsImages to set
 */
public void setSelectedTopinsImages(ArrayList<String> selectedTopinsImages) {
	this.selectedTopinsImages = selectedTopinsImages;
}

}
