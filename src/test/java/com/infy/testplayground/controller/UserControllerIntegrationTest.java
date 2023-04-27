package com.infy.testplayground.controller;

import com.infy.testplayground.config.AbstractIntegrationTest;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerIntegrationTest extends AbstractIntegrationTest {

    private final static String USER_PAYLOAD = "{\"id\":1,\"name\":\"test1\"}";

    @Test
    @Order(1)
    @SneakyThrows
    public void testGetUsers_success() {
        String body = mockMvc.perform(get("/users"))
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals("[]", body);
    }

    @Test
    @Order(2)
    @SneakyThrows
    public void testCreateUser_success() {
        String body = mockMvc.perform(
                    post("/users")
                            .contentType(APPLICATION_JSON)
                            .content(USER_PAYLOAD)
                )
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals(USER_PAYLOAD, body);
    }

    @Test
    @Order(3)
    @SneakyThrows
    public void testGetUserById_success() {
        String body = mockMvc.perform(get("/users/1"))
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals(USER_PAYLOAD, body);
    }

    @Test
    @Order(4)
    @SneakyThrows
    public void testDeleteUserById_success() {
        mockMvc.perform(delete("/users?id=1"))
                .andExpect(status().is2xxSuccessful());

        String body = mockMvc.perform(get("/users/1"))
                .andExpect(status().is2xxSuccessful())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertEquals("null", body);
    }
}
