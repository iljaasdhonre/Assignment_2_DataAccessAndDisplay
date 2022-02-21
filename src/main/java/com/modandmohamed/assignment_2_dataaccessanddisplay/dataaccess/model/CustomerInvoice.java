package com.modandmohamed.assignment_2_dataaccessanddisplay.dataaccess.model;

import java.util.Date;

public class CustomerInvoice {
    private int invoiceId; // p-key
    private int customerID; // f-key
    private Date invoiceDate;
    private String BillingAddress;
    private String BillingCity;
    private String BillingState;
    private String BillingCountry;
    private String BillingPostalCode;
    private Integer Total;

    public CustomerInvoice(int invoiceId, int customerID, Date invoiceDate, String billingAddress,
                           String billingCity, String billingState, String billingCountry,
                           String billingPostalCode, Integer total) {

        this.invoiceId = invoiceId;
        this.customerID = customerID;
        this.invoiceDate = invoiceDate;
        BillingAddress = billingAddress;
        BillingCity = billingCity;
        BillingState = billingState;
        BillingCountry = billingCountry;
        BillingPostalCode = billingPostalCode;
        Total = total;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getBillingAddress() {
        return BillingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        BillingAddress = billingAddress;
    }

    public String getBillingCity() {
        return BillingCity;
    }

    public void setBillingCity(String billingCity) {
        BillingCity = billingCity;
    }

    public String getBillingState() {
        return BillingState;
    }

    public void setBillingState(String billingState) {
        BillingState = billingState;
    }

    public String getBillingCountry() {
        return BillingCountry;
    }

    public void setBillingCountry(String billingCountry) {
        BillingCountry = billingCountry;
    }

    public String getBillingPostalCode() {
        return BillingPostalCode;
    }

    public void setBillingPostalCode(String billingPostalCode) {
        BillingPostalCode = billingPostalCode;
    }

    public Integer getTotal() {
        return Total;
    }

    public void setTotal(Integer total) {
        Total = total;
    }
}

