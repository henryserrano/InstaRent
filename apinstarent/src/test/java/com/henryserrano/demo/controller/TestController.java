package com.henryserrano.demo.controller;


import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.henryserrano.demo.repository.CustomerRepository;
import com.henryserrano.demo.service.ICustomerService;


class TestController{



	@Mock
	CustomerRepository repo;


    private MockMvc mockMvc;



    @Test
    public void deleteApplication() throws Exception {      
       
        mockMvc.perform(MockMvcRequestBuilders.delete("/customer", 1))
                .andExpect(status().isOk());
    }
}