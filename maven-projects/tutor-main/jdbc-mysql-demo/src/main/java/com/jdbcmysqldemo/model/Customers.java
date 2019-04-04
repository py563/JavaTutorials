package com.jdbcmysqldemo.model;

public class Customers {
    private int customerNumber;
    private String customerName;
    private String contactLastName;
    private String contactFirstName;
    private String phone;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String postalCode;
    private String country;
    private long salesRepEmployeeNumber; 
    private double creditLimit;
    /**
     * @param customerNumber the customerNumber to set
     */
    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }
    /**
     * @return the customerNumber
     */
    public int getCustomerNumber() {
        return customerNumber;
    }
    /**
     * @param customerName the customerName to set
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    /**
     * @return the customerName
     */
    public String getCustomerName() {
        return customerName;
    }

}