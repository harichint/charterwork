package com.charter.retailer.model;

import java.util.List;

/**
 * The type Reward response.
 */
public class RewardResponse {
    private String customerId;
    private List<MonthlyPoints> monthlyPoints;
    private long totalPoints;

    public RewardResponse(String customerId, List<MonthlyPoints> monthlyPoints, long totalPoints) {
        this.customerId = customerId;
        this.monthlyPoints = monthlyPoints;
        this.totalPoints = totalPoints;
    }

    public String getCustomerId() { return customerId; }

    public List<MonthlyPoints> getMonthlyPoints() { return monthlyPoints; }

    public long getTotalPoints() { return totalPoints; }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public void setMonthlyPoints(List<MonthlyPoints> monthlyPoints) {
        this.monthlyPoints = monthlyPoints;
    }

    public void setTotalPoints(long totalPoints) {
        this.totalPoints = totalPoints;
    }
}
