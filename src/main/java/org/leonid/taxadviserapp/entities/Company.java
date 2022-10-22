package org.leonid.taxadviserapp.entities;

public class Company {
    private int id;
    private String address;
    private String companyName;
    private String companyType;

    public Company(String companyName, String address, String companyType) {
        this.address = address;
        this.companyName = companyName;
        this.companyType = companyType;
    }

    public Company() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }
}
