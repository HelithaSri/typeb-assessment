package dev.helitha.typeb.controller;


import dev.helitha.typeb.service.HelloWorldService;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class HelloWorldControllerTest {

    private final MockMvc mockMvc = MockMvcBuilders
            .standaloneSetup(
                    new HelloWorldController(new HelloWorldService())
            )
            .build();


    @Test
    void shouldReturn200ForValidName() throws Exception {
        mockMvc.perform(get("/hello-world")
                        .param("name", "Alice"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message")
                        .value("Hello Alice"));
    }


    @Test
    void shouldReturn400ForInvalidName() throws Exception {
        mockMvc.perform(get("/hello-world")
                        .param("name", "Zara"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error")
                        .value("Invalid Input"));
    }

    @Test
    void shouldReturn400ForMissingName() throws Exception {
        mockMvc.perform(get("/hello-world"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error")
                        .value("Invalid Input"));
    }

    @Test
    void shouldReturn400ForEmptyName() throws Exception {
        mockMvc.perform(get("/hello-world")
                        .param("name", ""))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error")
                        .value("Invalid Input"));
    }

    @Test
    void shouldReturn400ForWhitespaceOnlyName() throws Exception {
        mockMvc.perform(get("/hello-world")
                        .param("name", "   "))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error")
                        .value("Invalid Input"));
    }

}
