package com.charter.retailer.service;

import com.charter.retailer.model.MonthlyPoints;
import com.charter.retailer.model.RewardResponse;
import com.charter.retailer.model.Transaction;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The type Rewards service.
 */
@Service
public class RewardsService {
    /**
     * Calculate points long.
     *
     * @param amount the amount
     * @return the long
     */
    public long calculatePoints(double amount) {
    long points = 0;
    if (amount > 100) {
        points += (Math.floor(amount - 100) * 2);
        points += 50; // 1 point for every dollar between 50 and 100
    } else if (amount > 50) {
        points += (Math.floor(amount - 50) * 1);
    }
    return points;
}

    /**
     * Process rewards reward response.
     *
     * @param customerId   the customer id
     * @param transactions the transactions
     * @param monthsLimit  the months limit
     * @return the reward response
     */
    public RewardResponse processRewards(java.lang.String customerId, List<Transaction> transactions, int monthsLimit) {
        LocalDate limitDate = LocalDate.now().minusMonths(monthsLimit);

        Map<Month, Long> pointsByMonth = transactions.stream()
                .filter(t -> t.getCustomerId().equals(customerId))
                .filter(t -> t.getTransactionDate().isAfter(limitDate))
                .collect(Collectors.groupingBy(
                        t -> t.getTransactionDate().getMonth(),
                        Collectors.summingLong(t -> calculatePoints(t.getAmount()))
                ));

        List<MonthlyPoints> monthlyDetails = pointsByMonth.entrySet().stream()
                .map(e -> new MonthlyPoints(e.getKey().name(), e.getValue()))
                .collect(Collectors.toList());

        long totalPoints = monthlyDetails.stream().mapToLong(MonthlyPoints::getPoints).sum();

        return new RewardResponse(customerId, monthlyDetails, totalPoints);
    }
}
