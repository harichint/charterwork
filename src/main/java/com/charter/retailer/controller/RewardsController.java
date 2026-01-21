package com.charter.retailer.controller;

import com.charter.retailer.model.RewardResponse;
import com.charter.retailer.service.DataSimulationService;
import com.charter.retailer.service.RewardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * The type Rewards controller.
 */
@RestController
@RequestMapping("/api/rewards")
public class RewardsController {

    private RewardsService rewardsService;
    private DataSimulationService dataService;

    @Autowired
    public RewardsController(RewardsService rewardsService, DataSimulationService dataService) {
        this.rewardsService = rewardsService;
        this.dataService = dataService;
    }

    /**
     * Gets rewards.
     *
     * @param customerIds the customer id
     * @param months     the months
     * @return rewards rewards
     */
    @GetMapping("/{customerId}")
    public CompletableFuture<RewardResponse> getRewards(
            //@PathVariable String customerId,
            @RequestBody List<String> customerIds,
            @RequestParam(defaultValue = "3") int months) {

        return dataService.fetchTransactionsAsync(customerIds).thenApply(transactions ->
            rewardsService.processRewards(customerIds, transactions, months)
        );
    }
}
