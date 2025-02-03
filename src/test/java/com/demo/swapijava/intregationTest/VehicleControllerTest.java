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
public class VehicleControllerTest {


    @Autowired
    private MockMvc mockMvc;

    @Test
    public void vehicleGetAllSuccessTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/swapi/vehicles")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }

    @Test
    public void vehicleGetByIdSuccessTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/swapi/vehicles/4")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers
                        .content()
                        .contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
    }


    @Test
    public void vehicleGetAllNotFoundTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/swapi/vehicle")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
    @Test
    public void vehicleGetByIdNotFoundTest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.get("/swapi/vehicles/500")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
