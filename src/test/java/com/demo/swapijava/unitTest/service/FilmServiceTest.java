package com.demo.swapijava.unitTest.service;

import com.demo.swapijava.entities.film.FilmResponseAll;
import com.demo.swapijava.entities.people.PeopleResponseAll;
import com.demo.swapijava.entities.people.PeopleResponseById;
import com.demo.swapijava.service.FilmServiceImpl;
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
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

public class FilmServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private FilmServiceImpl filmServiceImpl;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }


   @Test
    public void filmGetAllSuccessTest(){
        FilmResponseAll response = new FilmResponseAll();
        response.setMessage("ok");

        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                any(),
                eq(FilmResponseAll.class)
        )).thenReturn(ResponseEntity.ok(response));


        // Llamar al método findAll
        FilmResponseAll resultResponse = filmServiceImpl.findAll();

        // Asegúrate de que la respuesta es la esperada
        assertNotNull(resultResponse);
        assertEquals("ok", resultResponse.getMessage());
    }

    @Test
    public void filmGetAllNotFetchTest(){
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                any(),
                eq(PeopleResponseAll.class)
        )).thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        // Llamar al método y verificar que lanza la excepción correcta
        Exception exception = assertThrows(RuntimeException.class, () -> {
            filmServiceImpl.findAll();
        });

        assertEquals("An error occurred while fetching", exception.getMessage());
    }



    @Test
    public void filmFindByIdNotFoundTest() {
        // Simula un error 404 cuando no se encuentra el recurso
        when(restTemplate.exchange(
                anyString(),
                eq(HttpMethod.GET),
                any(),
                eq(PeopleResponseById.class)
        )).thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        // Llamar al método y verificar que lanza la excepción correcta
        Exception exception = assertThrows(RuntimeException.class, () -> {
            filmServiceImpl.findById(999L);
        });

        assertEquals("An error occurred while fetching person with id 999", exception.getMessage());
    }

    @Test
    public void filmFindByIdInvalidIdTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            filmServiceImpl.findById(-1L);
        });

        assertEquals("Invalid ID: -1", exception.getMessage());
    }
}
