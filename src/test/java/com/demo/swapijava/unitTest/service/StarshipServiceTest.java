package com.demo.swapijava.unitTest.service;

import com.demo.swapijava.entities.people.PeopleResponseAll;
import com.demo.swapijava.entities.people.PeopleResponseById;
import com.demo.swapijava.entities.starship.Properties;
import com.demo.swapijava.entities.starship.Result;
import com.demo.swapijava.entities.starship.StarshipResponseAll;
import com.demo.swapijava.entities.starship.StarshipResponseById;
import com.demo.swapijava.service.StarshipServiceImpl;
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

public class StarshipServiceTest {


    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private StarshipServiceImpl starshipServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void starshipGetAllSuccessTest(){
        StarshipResponseAll response = new StarshipResponseAll();
        response.setMessage("ok");

        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                any(),
                eq(StarshipResponseAll.class)
        )).thenReturn(ResponseEntity.ok(response));


        // Llamar al método findAll
        StarshipResponseAll resultResponse = starshipServiceImpl.findAll();

        // Asegúrate de que la respuesta es la esperada
        assertNotNull(resultResponse);
        assertEquals("ok", resultResponse.getMessage());

    }


    @Test
    public void starshipGetAllNotFetchTest(){
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                any(),
                eq(PeopleResponseAll.class)
        )).thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        // Llamar al método y verificar que lanza la excepción correcta
        Exception exception = assertThrows(RuntimeException.class, () -> {
            starshipServiceImpl.findAll();
        });

        assertEquals("An error occurred while fetching", exception.getMessage());
    }

    @Test
    public void starshipGetByIdSuccessTest() {


        StarshipResponseById response = new StarshipResponseById();
        Result result = new Result();
        Properties properties = new Properties();

        // Establecer los valores que esperas
        properties.setModel("CR90 corvette");
        properties.setStarshipClass("corvette");
        properties.setManufacturer("Corellian Engineering Corporation");
        properties.setCostInCredits("3500000");
        properties.setLength("150");
        properties.setCrew("30-165");
        properties.setPassengers("600");
        properties.setMaxAtmospheringSpeed("950");
        properties.setHyperdriveRating("2.0");
        properties.setMglt("60");
        properties.setCargoCapacity("3000000");
        properties.setConsumables("1 year");
        properties.setCreated("2020-09-17T17:55:06.604Z");
        properties.setEdited("2020-09-17T17:55:06.604Z");
        properties.setName("CR90 corvette");
        properties.setUrl("https://www.swapi.tech/api/starships/2");


        result.setProperties(properties);
        response.setMessage("ok");
        response.setResult(result);

        // Simula la respuesta del RestTemplate
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                any(),
                eq(StarshipResponseById.class)
        )).thenReturn(ResponseEntity.ok(response));

        // Llamar al método findById
        StarshipResponseById resultResponse = starshipServiceImpl.findById(2L);

        // Asegúrate de que la respuesta es la esperada
        assertNotNull(resultResponse);
        assertEquals("ok", resultResponse.getMessage());
        assertEquals(response, resultResponse);
    }


    @Test
    public void starshipFindByIdNotFoundTest() {
        // Simula un error 404 cuando no se encuentra el recurso
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                any(),
                eq(PeopleResponseById.class)
        )).thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        // Llamar al método y verificar que lanza la excepción correcta
        Exception exception = assertThrows(RuntimeException.class, () -> {
            starshipServiceImpl.findById(999L);
        });

        assertEquals("An error occurred while fetching starship with id 999", exception.getMessage());
    }

    @Test
    public void starshipFindByIdInvalidIdTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            starshipServiceImpl.findById(-1L);
        });

        assertEquals("Invalid ID: -1", exception.getMessage());
    }

}
