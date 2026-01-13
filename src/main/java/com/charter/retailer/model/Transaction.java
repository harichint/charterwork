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

    public Transaction(String transactionId, String customerId, double amount, LocalDate transactionDate) {
        this.transactionId = transactionId;
        this.customerId = customerId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    public String getCustomerId() { return customerId; }

    public double getAmount() { return amount; }

    public LocalDate getTransactionDate() { return transactionDate; }
}
