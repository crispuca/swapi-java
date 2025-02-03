package com.demo.swapijava.unitTest.service;


import com.demo.swapijava.entities.people.PeopleResponseAll;
import com.demo.swapijava.entities.people.PeopleResponseById;
import com.demo.swapijava.entities.species.Properties;
import com.demo.swapijava.entities.species.Result;
import com.demo.swapijava.entities.species.SpecieResponseAll;
import com.demo.swapijava.entities.species.SpecieResponseById;
import com.demo.swapijava.service.SpecieServiceImpl;
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

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class SpecieServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private SpecieServiceImpl specieServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void specieGetAllSuccessTest(){
        SpecieResponseAll response = new SpecieResponseAll();
        response.setMessage("ok");

        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                any(),
                eq(SpecieResponseAll.class)
        )).thenReturn(ResponseEntity.ok(response));


        // Llamar al método findAll
        SpecieResponseAll resultResponse = specieServiceImpl.findAll();

        // Asegúrate de que la respuesta es la esperada
        assertNotNull(resultResponse);
        assertEquals("ok", resultResponse.getMessage());

    }

    @Test
    public void specieGetAllNotFetchTest(){
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                any(),
                eq(PeopleResponseAll.class)
        )).thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        // Llamar al método y verificar que lanza la excepción correcta
        Exception exception = assertThrows(RuntimeException.class, () -> {
            specieServiceImpl.findAll();
        });

        assertEquals("An error occurred while fetching", exception.getMessage());
    }

    @Test
    public void specieGetByIdSuccessTest() {


        SpecieResponseById response = new SpecieResponseById();
        Result result = new Result();
        Properties properties = new Properties();

        // Establecer los valores que esperas
        properties.setClassification("artificial");
        properties.setDesignation("sentient");
        properties.setAverageHeight("n/a");
        properties.setAverageLifespan("indefinite");
        properties.setHairColors("n/a");
        properties.setSkinColors("n/a");
        properties.setEyeColors("n/a");
        properties.setCreated("2025-02-02T13:42:49.781Z");
        properties.setEdited("2025-02-02T13:42:49.781Z");
        properties.setName("Droid");
        properties.setHomeWorld("https://www.swapi.tech/api/planets/2");
        properties.setUrl("https://www.swapi.tech/api/species/2");


        List<String> people = new ArrayList<>(Arrays.asList(
                "https://www.swapi.tech/api/people/2",
                "https://www.swapi.tech/api/people/3",
                "https://www.swapi.tech/api/people/8",
                "https://www.swapi.tech/api/people/23"
        ));

        properties.setPeopleUrls(people);

        result.setProperties(properties);
        response.setMessage("ok");
        response.setResult(result);

        // Simula la respuesta del RestTemplate
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                any(),
                eq(SpecieResponseById.class)
        )).thenReturn(ResponseEntity.ok(response));

        // Llamar al método findById
        SpecieResponseById resultResponse = specieServiceImpl.findById(2L);

        // Asegúrate de que la respuesta es la esperada
        assertNotNull(resultResponse);
        assertEquals("ok", resultResponse.getMessage());
        assertEquals(response, resultResponse);
    }


    @Test
    public void specieFindByIdNotFoundTest() {
        // Simula un error 404 cuando no se encuentra el recurso
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                any(),
                eq(PeopleResponseById.class)
        )).thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        // Llamar al método y verificar que lanza la excepción correcta
        Exception exception = assertThrows(RuntimeException.class, () -> {
            specieServiceImpl.findById(999L);
        });

        assertEquals("An error occurred while fetching specie with id 999", exception.getMessage());
    }

    @Test
    public void specieFindByIdInvalidIdTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            specieServiceImpl.findById(-1L);
        });

        assertEquals("Invalid ID: -1", exception.getMessage());
    }

}
