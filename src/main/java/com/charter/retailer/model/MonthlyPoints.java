package com.charter.retailer.model;

/**
 * Represents the total reward points earned by a customer
 * within a specific calendar month.
 */
public class MonthlyPoints {
    private String month;
    private long points;

    /**
     * Instantiates a new Monthly points.
     *
     * @param month  the month  e.g., "JANUARY"
     * @param points the points Total points for that month
     */
    public MonthlyPoints(String month, long points) {
        this.month = month;
        this.points = points;
    }

    /**
     * Gets month.
     *
     * @return the month
     */
    public String getMonth() {
        return month;
    }

    /**
     * Gets points.
     *
     * @return the points
     */
    public long getPoints() {
        return points;
    }

    /**
     * Sets month.
     *
     * @param month the month
     */
// Setters (Optional, but good for framework compatibility)
    public void setMonth(String month) {
        this.month = month;
    }

    /**
     * Sets points.
     *
     * @param points the points
     */
    public void setPoints(long points) {
        this.points = points;
    }
}
