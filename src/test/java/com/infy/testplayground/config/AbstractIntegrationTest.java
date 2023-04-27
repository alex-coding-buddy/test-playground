package com.infy.testplayground.config;

import com.infy.testplayground.TestPlaygroundApplication;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.MethodOrderer.*;

@SpringBootTest(classes = TestPlaygroundApplication.class)
@AutoConfigureMockMvc
//@WebMvcTest
@ActiveProfiles(profiles = "integrationtest")
@TestMethodOrder(OrderAnnotation.class)
public abstract class AbstractIntegrationTest {

    @Autowired
    protected MockMvc mockMvc;
}
