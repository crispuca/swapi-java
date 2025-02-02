package com.demo.swapijava.intregation;

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
public class SpecieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void specieGetAllSuccessTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/swapi/species")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void specieGetByIdSuccessTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/swapi/species/4")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }


    @Test
    public void specieGetAllNotFoundTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/swapi/specie")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
    @Test
    public void specieGetByIdNotFoundTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/swapi/specie/500")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

}
