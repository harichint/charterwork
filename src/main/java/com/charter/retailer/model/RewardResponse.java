package com.charter.retailer.model;

import java.util.List;
import java.util.Map;

/**
 * The type Reward response.
 */
public class RewardResponse {

    private Map<String, Long> customerTotalPoints;
    private List<Transaction> transactionList;

    public RewardResponse(//List<MonthlyPoints> monthlyPoints,
                          List<Transaction> transactions,
                          Map<String, Long> customerTotalPoints) {
        this.customerTotalPoints = customerTotalPoints;
        this.transactionList = transactions;
    }

    public List<Transaction> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transaction> transactionList) {
        this.transactionList = transactionList;
    }

    public Map<String, Long> getCustomerTotalPoints() {
        return customerTotalPoints;
    }

    public void setCustomerTotalPoints(Map<String, Long> customerTotalPoints) {
        this.customerTotalPoints = customerTotalPoints;
    }
}
