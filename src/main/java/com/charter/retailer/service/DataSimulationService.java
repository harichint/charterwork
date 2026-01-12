package com.charter.retailer.service;

import com.charter.retailer.model.Transaction;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * The type Data simulation service.
 */
@Service
public class DataSimulationService {

    /**
     * Simulates an asynchronous API call to fetch transaction data.
     *
     * @return the java . util . concurrent . completable future
     */
    public java.util.concurrent.CompletableFuture<List<Transaction>> fetchTransactionsAsync() {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500); // Simulate network latency
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            List<Transaction> transactions = new ArrayList<>();
            String cid = "CUST001";

            // Month 1
            transactions.add(new Transaction("T1", cid, 120.0, LocalDate.now().minusMonths(0))); // 90 pts
            // Month 2
            transactions.add(new Transaction("T2", cid, 80.0, LocalDate.now().minusMonths(1)));  // 30 pts
            // Month 3
            transactions.add(new Transaction("T3", cid, 50.0, LocalDate.now().minusMonths(2)));  // 0 pts
            transactions.add(new Transaction("T4", cid, 200.0, LocalDate.now().minusMonths(2))); // 250 pts

            return transactions;
        });
    }
}
