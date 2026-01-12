package com.charter.retailer.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import com.charter.retailer.model.RewardResponse;
import com.charter.retailer.service.DataSimulationService;
import com.charter.retailer.service.RewardsService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;


@WebMvcTest(RewardsController.class)
class RewardsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RewardsService rewardsService;

    @MockBean
    private DataSimulationService dataService;

    @Test
    @DisplayName("getRewards_ShouldReturnRewardResponse ")
    void getRewards_ShouldReturnRewardResponse() throws Exception {
        // 1. Prepare Mock Data
        String customerId = "C123";
        RewardResponse mockResponse = new RewardResponse(customerId, null, 150); // Assume this has standard getters/setters

        // 2. Mock Asynchronous Behavior
        // Return a completed future from the simulated data service
        when(dataService.fetchTransactionsAsync())
                .thenReturn(CompletableFuture.completedFuture(Collections.emptyList()));

        // Mock the processing logic
        when(rewardsService.processRewards(eq(customerId), anyList(), anyInt()))
                .thenReturn(mockResponse);

        // 3. Perform Initial Request
        // Spring exits the servlet thread and starts async processing
        MvcResult mvcResult = mockMvc.perform(get("/api/rewards/{customerId}", customerId)
                        .param("months", "3")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(request().asyncStarted()) // Verify async process initiated
                .andReturn();

        // 4. Perform Async Dispatch and Verify Final Result
        // Use asyncDispatch to resume processing on the same result
        mockMvc.perform(asyncDispatch(mvcResult))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.totalPoints").value(150));
    }
}
