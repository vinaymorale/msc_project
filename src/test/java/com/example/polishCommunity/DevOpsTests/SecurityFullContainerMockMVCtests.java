package com.example.polishCommunity.DevOpsTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class SecurityFullContainerMockMVCtests {

    @Autowired
    private MockMvc mockMvc;

    // Unit tests using a mock MVC to a secured route - This will fail so test for the failure.
    @Test
    public void addpolicysecure() throws Exception {
        this.mockMvc.perform(get("/addNewPolicy/1")).andDo(print()).andExpect(status().isFound())
                .andExpect(header().string("Location",  "http://localhost/signin-register"));
    }

    // Unit tests using a mock MVC to a secured route but logged in - this should succeed.
    @Test
    public void addpolicylogin() throws Exception {
        this.mockMvc.perform(get("/addNewPolicy/1")
                .with(SecurityMockMvcRequestPostProcessors.user("ian@gmail.com").roles("Admin")) )
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Add")));
    }

    //  test using a mock MVC but a test database to a secured route - This will fail so test for the failure.
//    @Test
//    public void deleteItemTest() throws Exception {
//        this.mockMvc.perform(get("/Admin/DeleteItem")).andDo(print()).andExpect(status().isFound())
//                .andExpect(header().string("Location",  "http://localhost/login"));
//    }
//
//    @Test
//    public void deleteItemTestLoggedIn() throws Exception {
//        this.mockMvc.perform(get("/Admin/DeleteItem")
//                .with(SecurityMockMvcRequestPostProcessors.user("user").roles("USER")) )
//                .andDo(print())
//                .andExpect(status().isOk())
//                .andExpect(content().string(containsString("Delete Item Page")));
//    }

}
