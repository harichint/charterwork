package com.retailer.rewards.model;

/**
 * Represents the total reward points earned by a customer
 * within a specific calendar month.
 */
public class MonthlyPoints {
    private String month; // e.g., "JANUARY"
    private long points;  // Total points for that month

    // Constructor
    public MonthlyPoints(String month, long points) {
        this.month = month;
        this.points = points;
    }

    // Getters
    // (Spring Boot's Jackson library uses these to build the JSON response)
    public String getMonth() {
        return month;
    }

    public long getPoints() {
        return points;
    }

    // Setters (Optional, but good for framework compatibility)
    public void setMonth(String month) {
        this.month = month;
    }

    public void setPoints(long points) {
        this.points = points;
    }
}
