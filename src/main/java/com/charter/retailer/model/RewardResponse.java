package com.charter.retailer.model;

import java.util.List;

/**
 * The type Reward response.
 */
public class RewardResponse {
    private String customerId;
    private List<MonthlyPoints> monthlyPoints;
    private long totalPoints;

    /**
     * Instantiates a new Reward response.
     *
     * @param customerId    the customer id
     * @param monthlyPoints the monthly points
     * @param totalPoints   the total points
     */
    public RewardResponse(String customerId, List<MonthlyPoints> monthlyPoints, long totalPoints) {
        this.customerId = customerId;
        this.monthlyPoints = monthlyPoints;
        this.totalPoints = totalPoints;
    }

    /**
     * Gets customer id.
     *
     * @return the customer id
     */
    public String getCustomerId() { return customerId; }

    /**
     * Gets monthly points.
     *
     * @return the monthly points
     */
    public List<MonthlyPoints> getMonthlyPoints() { return monthlyPoints; }

    /**
     * Gets total points.
     *
     * @return the total points
     */
    public long getTotalPoints() { return totalPoints; }

    /**
     * Sets customer id.
     *
     * @param customerId the customer id
     */
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    /**
     * Sets monthly points.
     *
     * @param monthlyPoints the monthly points
     */
    public void setMonthlyPoints(List<MonthlyPoints> monthlyPoints) {
        this.monthlyPoints = monthlyPoints;
    }

    /**
     * Sets total points.
     *
     * @param totalPoints the total points
     */
    public void setTotalPoints(long totalPoints) {
        this.totalPoints = totalPoints;
    }
}
