package com.example.demo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(TestController.class)
public class TestControllerTest {

    @Autowired
    private MockMvc mvc;


    @Test
    public void getHome() throws Exception {
        mvc.perform(get("/test/home"))
                .andExpect(status().isOk()) // Ensure HTTP 200 status
                .andExpect(content().string("home")); // Validate the response body
    }

    @Test
    public void getMe() throws Exception {
        mvc.perform(get("/test/me")
                        .accept(MediaType.APPLICATION_JSON)) // Set the expected response type
                .andExpect(status().isOk()) // Ensure HTTP 200 status
                .andExpect(jsonPath("$.id").value(12L)) // Validate 'id' field
                .andExpect(jsonPath("$.firstName").value("Bibhu")) // Validate 'firstName' field
                .andExpect(jsonPath("$.lastName").value("Dash")); // Validate 'lastName' field
    }
}
