package com.demo.swapijava.unitTest.service;

import com.demo.swapijava.entities.people.*;
import com.demo.swapijava.service.PeopleServiceImpl;
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
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

public class PeopleServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PeopleServiceImpl peopleServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


    @Test
    public void peopleGetAllSuccessTest(){
        PeopleResponseAll response = new PeopleResponseAll();
        response.setMessage("ok");

        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                any(),
                eq(PeopleResponseAll.class)
        )).thenReturn(ResponseEntity.ok(response));


        // Llamar al método findAll
        PeopleResponseAll resultResponse = peopleServiceImpl.findAll();

        // Asegúrate de que la respuesta es la esperada
        assertNotNull(resultResponse);
        assertEquals("ok", resultResponse.getMessage());

    }


    @Test
    public void peopleGetAllNotFetchTest(){
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                any(),
                eq(PeopleResponseAll.class)
        )).thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        // Llamar al método y verificar que lanza la excepción correcta
        Exception exception = assertThrows(RuntimeException.class, () -> {
            peopleServiceImpl.findAll();
        });

        assertEquals("An error occurred while fetching", exception.getMessage());
    }



    @Test
    public void peopleGetByIdSuccessTest() {


        PeopleResponseById response = new PeopleResponseById();
        Result result = new Result();
        Properties properties = new Properties();

        // Establecer los valores que esperas
        properties.setHeight("167");
        properties.setMass("75");
        properties.setHairColor("n/a");
        properties.setSkinColor("gold");
        properties.setEyeColor("yellow");
        properties.setBirthYear("112BBY");
        properties.setGender("n/a");
        properties.setCreated("2025-02-01T13:17:19.027Z");
        properties.setEdited("2025-02-01T13:17:19.027Z");
        properties.setName("C-3PO");
        properties.setHomeworld("https://www.swapi.tech/api/planets/1");
        properties.setUrl("https://www.swapi.tech/api/people/2");

        result.setProperties(properties);
        response.setMessage("ok");
        response.setResult(result);

        // Simula la respuesta del RestTemplate
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                any(),
                eq(PeopleResponseById.class)
        )).thenReturn(ResponseEntity.ok(response));

        // Llamar al método findById
        PeopleResponseById resultResponse = peopleServiceImpl.findById(2L);

        // Asegúrate de que la respuesta es la esperada
        assertNotNull(resultResponse);
        assertEquals("ok", resultResponse.getMessage());
        assertEquals(response, resultResponse);
    }



    @Test
    public void peopleFindByIdNotFoundTest() {
        // Simula un error 404 cuando no se encuentra el recurso
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                any(),
                eq(PeopleResponseById.class)
        )).thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        // Llamar al método y verificar que lanza la excepción correcta
        Exception exception = assertThrows(RuntimeException.class, () -> {
            peopleServiceImpl.findById(999L);
        });

        assertEquals("An error occurred while fetching person with id 999", exception.getMessage());
    }

    @Test
    public void peopleFindByIdInvalidIdTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            peopleServiceImpl.findById(-1L);
        });

        assertEquals("Invalid ID: -1", exception.getMessage());
    }
}
