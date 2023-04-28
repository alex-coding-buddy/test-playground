package com.infy.testplayground.controller;

import com.infy.testplayground.config.AbstractIntegrationTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class Task2IntegrationService extends AbstractIntegrationTest {

    private final static String RELATION_PAYLOAD = "{\n" +
            "  \"w1\": \"son\",\n" +
            "  \"w2\": \"daughter\",\n" +
            "  \"r\": \"ANTONYM\"\n" +
            "}";

    @Test
    @Order(1)
    @SneakyThrows
    public void testPostRelation_success() {
        mockMvc.perform(
                        post("/relations/task1")
                                .contentType(APPLICATION_JSON)
                                .content(RELATION_PAYLOAD)
                )
                .andExpect(status().is2xxSuccessful());

        String wordsResponse = mockMvc.perform(get("/words"))
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertTrue(wordsResponse.contains("relation"));
    }

}
