package com.example.polishCommunity.DevOpsTests;

import com.example.polishCommunity.controller.RightsController;
import com.example.polishCommunity.model.Rights;

import com.example.polishCommunity.service.*;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = RightsController.class)
public class LightweightMVCtest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private RightsService rightsService;

    @MockBean
    private JdbcTemplate jdbcTemplate;



    @Test
    public void titletest() throws Exception {
        Rights right = new Rights(1, "Test Title", "Test Description");
        given(rightsService.getRightsByTitleId(1)).willReturn(right);

        this.mockMvc.perform(get("/rightsView/1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Test Title")));
    }
}