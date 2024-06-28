package ru.vkarikov.validation.controller;

import org.hamcrest.core.Is;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@WebMvcTest
@AutoConfigureMockMvc
class CustomerControllerTest {
    @Autowired
    private CustomerController customerController;
    @Autowired
    private MockMvc mockMvc;

    @Test
    void name() throws Exception {
        String customer = "{\"name\": \"company one\", \"inn\" : \" \"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/customers")
                        .content(customer)
                        .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(MockMvcResultMatchers.status().isBadRequest());
    }
}