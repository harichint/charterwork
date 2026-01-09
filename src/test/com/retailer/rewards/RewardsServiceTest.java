package com.retailer.rewards;

import com.retailer.rewards.service.RewardsService;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RewardsServiceTest {

    private final RewardsService rewardsService = new RewardsService();

    @Test
    public void testCalculatePoints_Above100() {
        // 120 -> 2*(120-100) + 1*(100-50) = 40 + 50 = 90
        assertEquals(90, rewardsService.calculatePoints(120.0));
    }

    @Test
    public void testCalculatePoints_Between50And100() {
        // 80 -> 1*(80-50) = 30
        assertEquals(30, rewardsService.calculatePoints(80.0));
    }

    @Test
    public void testCalculatePoints_Below50() {
        assertEquals(0, rewardsService.calculatePoints(45.0));
    }
}
