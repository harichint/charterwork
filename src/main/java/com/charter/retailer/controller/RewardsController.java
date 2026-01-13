package com.charter.retailer.controller;

import com.charter.retailer.model.RewardResponse;
import com.charter.retailer.service.DataSimulationService;
import com.charter.retailer.service.RewardsService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletableFuture;

/**
 * The type Rewards controller.
 */
@RestController
@RequestMapping("/api/rewards")
public class RewardsController {

    private RewardsService rewardsService;
    private DataSimulationService dataService;

    public RewardsController(RewardsService rewardsService, DataSimulationService dataService) {
        this.rewardsService = rewardsService;
        this.dataService = dataService;
    }

    /**
     * Gets rewards.
     *
     * @param customerId the customer id
     * @param months     the months
     * @return rewards rewards
     */
    @GetMapping("/{customerId}")
    public CompletableFuture<RewardResponse> getRewards(
            @PathVariable String customerId,
            @RequestParam(defaultValue = "3") int months) {

        return dataService.fetchTransactionsAsync().thenApply(transactions ->
            rewardsService.processRewards(customerId, transactions, months)
        );
    }
}
