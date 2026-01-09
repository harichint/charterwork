package com.retailer.rewards.model;

import java.util.List;

public class RewardResponse {
    private java.lang.String customerId;
    private java.util.List<MonthlyPoints> monthlyPoints;
    private long totalPoints;

    public RewardResponse(java.lang.String customerId, java.util.List<MonthlyPoints> monthlyPoints, long totalPoints) {
        this.customerId = customerId;
        this.monthlyPoints = monthlyPoints;
        this.totalPoints = totalPoints;
    }

    // Getters...
    public java.lang.String getCustomerId() { return customerId; }
    public java.util.List<MonthlyPoints> getMonthlyPoints() { return monthlyPoints; }
    public long getTotalPoints() { return totalPoints; }
}
