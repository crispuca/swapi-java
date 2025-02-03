package com.demo.swapijava.unitTest.service;

import com.demo.swapijava.entities.people.PeopleResponseAll;
import com.demo.swapijava.entities.people.PeopleResponseById;
import com.demo.swapijava.entities.vehicle.Properties;
import com.demo.swapijava.entities.vehicle.Result;
import com.demo.swapijava.entities.vehicle.VehicleResponseAll;
import com.demo.swapijava.entities.vehicle.VehicleResponseById;
import com.demo.swapijava.service.VehicleServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class VehicleServiceTest {



    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private VehicleServiceImpl vehicleServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }



    @Test
    public void vehicleGetAllSuccessTest(){
        VehicleResponseAll response = new VehicleResponseAll();
        response.setMessage("ok");

        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                any(),
                eq(VehicleResponseAll.class)
        )).thenReturn(ResponseEntity.ok(response));


        // Llamar al método findAll
        VehicleResponseAll resultResponse = vehicleServiceImpl.findAll();

        // Asegúrate de que la respuesta es la esperada
        assertNotNull(resultResponse);
        assertEquals("ok", resultResponse.getMessage());

    }


    @Test
    public void vehicleGetAllNotFetchTest(){
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                any(),
                eq(PeopleResponseAll.class)
        )).thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        // Llamar al método y verificar que lanza la excepción correcta
        Exception exception = assertThrows(RuntimeException.class, () -> {
            vehicleServiceImpl.findAll();
        });

        assertEquals("An error occurred while fetching", exception.getMessage());
    }

    @Test
    public void vehicleGetByIdSuccessTest() {


        VehicleResponseById response = new VehicleResponseById();
        Result result = new Result();
        Properties properties = new Properties();

        // Establecer los valores que esperas
        properties.setModel("Digger Crawler");
        properties.setVehicleClass("wheeled");
        properties.setManufacturer("Corellia Mining Corporation");
        properties.setCostInCredits("150000");
        properties.setLength("36.8 ");
        properties.setCrew("46");
        properties.setPassengers("30");
        properties.setMaxAtmospheringSpeed("30");
        properties.setCargoCapacity("50000");
        properties.setConsumables("2 months");
        properties.setCreated("2020-09-17T17:46:31.415Z");
        properties.setEdited("2020-09-17T17:46:31.415Z");
        properties.setName("Sand Crawler");
        properties.setUrl("https://www.swapi.tech/api/vehicles/4");


        result.setProperties(properties);
        response.setMessage("ok");
        response.setResult(result);

        // Simula la respuesta del RestTemplate
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                any(),
                eq(VehicleResponseById.class)
        )).thenReturn(ResponseEntity.ok(response));

        // Llamar al método findById
        VehicleResponseById resultResponse = vehicleServiceImpl.findById(4L);

        // Asegúrate de que la respuesta es la esperada
        assertNotNull(resultResponse);
        assertEquals("ok", resultResponse.getMessage());
        assertEquals(response, resultResponse);
    }

    @Test
    public void vehicleFindByIdNotFoundTest() {
        // Simula un error 404 cuando no se encuentra el recurso
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                any(),
                eq(PeopleResponseById.class)
        )).thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        // Llamar al método y verificar que lanza la excepción correcta
        Exception exception = assertThrows(RuntimeException.class, () -> {
            vehicleServiceImpl.findById(999L);
        });

        assertEquals("An error occurred while fetching vehicle with id 999", exception.getMessage());
    }

    @Test
    public void vehicleFindByIdInvalidIdTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            vehicleServiceImpl.findById(-1L);
        });

        assertEquals("Invalid ID: -1", exception.getMessage());
    }

}
