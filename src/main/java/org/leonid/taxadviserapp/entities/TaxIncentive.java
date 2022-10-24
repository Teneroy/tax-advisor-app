package org.leonid.taxadviserapp.entities;

public class TaxIncentive {
    private int taxIncentiveId;
    private String taxIncentiveName;
    private float taxIncentivePercentage;
    private String companyTypeForTaxIncentive;
    private int ageRangeForTaxIncentive;

    public TaxIncentive(String taxIncentiveName, String companyTypeForTaxIncentive, float taxIncentivePercentage, int ageRangeForTaxIncentive) {
        this.taxIncentiveName = taxIncentiveName;
        this.taxIncentivePercentage = taxIncentivePercentage;
        this.companyTypeForTaxIncentive = companyTypeForTaxIncentive;
        this.ageRangeForTaxIncentive = ageRangeForTaxIncentive;
    }

    public TaxIncentive() {
    }


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
