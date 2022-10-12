package org.leonid.taxadviserapp.entities;

public class TaxIncentives {
    private int taxIncentiveId;
    private String taxIncentiveName;
    private float taxIncentivePercentage;
    private String companyTypeForTaxIncentive;
    private int ageRangeForTaxIncentive;

    public int getTaxIncentiveId() {
        return taxIncentiveId;
    }

    public void setTaxIncentiveId(int taxIncentiveId) {
        this.taxIncentiveId = taxIncentiveId;
    }

    public String getTaxIncentiveName() {
        return taxIncentiveName;
    }

    public void setTaxIncentiveName(String taxIncentiveName) {
        this.taxIncentiveName = taxIncentiveName;
    }

    public float getTaxIncentivePercentage() {
        return taxIncentivePercentage;
    }

    public void setTaxIncentivePercentage(float taxIncentivePercentage) {
        this.taxIncentivePercentage = taxIncentivePercentage;
    }

    public String getCompanyTypeForTaxIncentive() {
        return companyTypeForTaxIncentive;
    }

    public void setCompanyTypeForTaxIncentive(String companyTypeForTaxIncentive) {
        this.companyTypeForTaxIncentive = companyTypeForTaxIncentive;
    }

    public int getAgeRangeForTaxIncentive() {
        return ageRangeForTaxIncentive;
    }

    public void setAgeRangeForTaxIncentive(int ageRangeForTaxIncentive) {
        this.ageRangeForTaxIncentive = ageRangeForTaxIncentive;
    }
}
