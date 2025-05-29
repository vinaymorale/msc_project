package com.example.polishCommunity.DevOpsTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ItemMVCtest {

        @Autowired
        private MockMvc mockMvc;

        // Unit tests using a mock MVC
        @Test
        public void mvctest() throws Exception {
            this.mockMvc.perform(get("/rightsView/1")).andDo(print()).andExpect(status().isOk())
                    .andExpect(content().string(containsString("FAQs")));
        }
    @Test
    public void FAQtest() throws Exception {
        this.mockMvc.perform(get("/rights/1")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Frequently")));
    }

//    @Test
//    public void a_testGreeting1() throws Exception {
//        this.mockMvc.perform(get("/rightsView/1")).andDo(print()).andExpect(status().isOk())
//                .andExpect(content().string(containsString("mock")));
//    }


    }



