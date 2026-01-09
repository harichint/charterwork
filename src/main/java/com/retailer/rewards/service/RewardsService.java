package com.retailer.rewards.service;

import com.retailer.rewards.model.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class RewardsService {    public long calculatePoints(double amount) {
    long points = 0;
    if (amount > 100) {
        points += (Math.floor(amount - 100) * 2);
        points += 50; // 1 point for every dollar between 50 and 100
    } else if (amount > 50) {
        points += (Math.floor(amount - 50) * 1);
    }
    return points;
}

    public RewardResponse processRewards(java.lang.String customerId, java.util.List<Transaction> transactions, int monthsLimit) {
        java.time.LocalDate limitDate = LocalDate.now().minusMonths(monthsLimit);

        java.util.Map<Month, java.lang.Long> pointsByMonth = transactions.stream()
                .filter(t -> t.getCustomerId().equals(customerId))
                .filter(t -> t.getTransactionDate().isAfter(limitDate))
                .collect(Collectors.groupingBy(
                        t -> t.getTransactionDate().getMonth(),
                        Collectors.summingLong(t -> calculatePoints(t.getAmount()))
                ));

        java.util.List<MonthlyPoints> monthlyDetails = pointsByMonth.entrySet().stream()
                .map(e -> new MonthlyPoints(e.getKey().name(), e.getValue()))
                .collect(Collectors.toList());

        long totalPoints = monthlyDetails.stream().mapToLong(MonthlyPoints::getPoints).sum();

        return new RewardResponse(customerId, monthlyDetails, totalPoints);
    }
}
