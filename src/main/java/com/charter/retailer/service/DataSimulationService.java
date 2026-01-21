package com.charter.retailer.service;

import com.charter.retailer.model.Transaction;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
    public CompletableFuture<List<Transaction>> fetchTransactionsAsync(List<String> customerIds) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
            int min = 49;
            int max = 200;

            Random rand = new Random();

            List<Transaction> transactions = new ArrayList<>();
            for (String cid: customerIds) {
                // Month 1
                transactions.add(new Transaction("T1", cid, rand.nextLong(max-min + 1) + min, LocalDate.now().minusMonths(0))); // 90 pts
                // Month 2
                transactions.add(new Transaction("T2", cid, rand.nextLong(max-min + 1) + min, LocalDate.now().minusMonths(1)));  // 30 pts
                // Month 3
                transactions.add(new Transaction("T3", cid, rand.nextLong(max-min + 1) + min, LocalDate.now().minusMonths(2)));  // 0 pts
                transactions.add(new Transaction("T4", cid, rand.nextLong(max-min + 1) + min, LocalDate.now().minusMonths(2))); // 250 pts
                transactions.add(new Transaction("T5", cid, rand.nextLong(max-min + 1) + min, LocalDate.now().minusMonths(0))); // 90 pts
            }
            return transactions;
        });
    }
}
