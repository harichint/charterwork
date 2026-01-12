package com.charter.retailer.model;

import java.time.LocalDate;

/**
 * The type Transaction.
 */
public class Transaction {
    private String transactionId;
    private String customerId;
    private double amount;
    private LocalDate transactionDate;

    /**
     * Instantiates a new Transaction.
     *
     * @param transactionId   the transaction id
     * @param customerId      the customer id
     * @param amount          the amount
     * @param transactionDate the transaction date
     */
    public Transaction(String transactionId, String customerId, double amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    /**
     * Gets customer id.
     *
     * @return the customer id
     */
    public String getCustomerId() { return customerId; }

    /**
     * Gets amount.
     *
     * @return the amount
     */
    public double getAmount() { return amount; }

    /**
     * Gets transaction date.
     *
     * @return the transaction date
     */
    public LocalDate getTransactionDate() { return transactionDate; }
}
