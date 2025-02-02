package com.demo.swapijava.intregation;


import com.demo.swapijava.security.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Import(SecurityConfig.class)
public class PeopleControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void peopleGetAllSuccessTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/swapi/people")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void peopleGetByIdSuccessTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/swapi/people/4")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void peopleGetAllNotFoundTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/swapi/peopl")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
    @Test
    public void peopleGetByIdNotFoundTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/swapi/people/500")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
