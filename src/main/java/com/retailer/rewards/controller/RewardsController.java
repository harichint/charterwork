package com.retailer.rewards.controller;

import com.retailer.rewards.model.RewardResponse;
import com.retailer.rewards.service.DataSimulationService;
import com.retailer.rewards.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api/rewards")
public class RewardsController {

    @Autowired
    private RewardsService rewardsService;

    @Autowired
    private DataSimulationService dataService;

    @GetMapping("/{customerId}")
    public CompletableFuture<RewardResponse> getRewards(
            @PathVariable String customerId,
            @RequestParam(defaultValue = "3") int months) {

        return dataService.fetchTransactionsAsync().thenApply(transactions ->
            rewardsService.processRewards(customerId, transactions, months)
        );
    }
}
