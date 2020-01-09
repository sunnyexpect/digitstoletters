package com.example.sunny.digitstoletters.controller;

import com.example.sunny.digitstoletters.service.IDTLServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class DTLControllerTest {

    @Autowired
    private  DTLController dtlController;
    private MockMvc mockMvc;

    @MockBean
    private IDTLServiceImpl dtlService;

    @BeforeEach
    public void setup() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(dtlController).build();
    }

    @Test
    void digits() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/digits?inputData=1,2,3"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}