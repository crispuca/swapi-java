package com.demo.swapijava.intregationTest;

import com.demo.swapijava.security.SecurityConfig;
import org.junit.jupiter.api.Test;
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
public class FilmControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void filmGetAllSuccessTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/swapi/films")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void filmGetByIdSuccessTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/swapi/films/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }


    @Test
    public void filmGetAllNotFoundTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/swapi/film")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
    @Test
    public void filmGetByIdNotFoundTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/swapi/films/500")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

}
