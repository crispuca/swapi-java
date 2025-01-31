package com.demo.swapijava.service;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import com.demo.swapijava.entities.film.FilmResponseAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

class FilmServiceImplTest {

    @Mock
    private RestTemplate restTemplate;

    private FilmServiceImpl filmServiceImpl;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        filmServiceImpl = new FilmServiceImpl(restTemplate);
    }

    @Test
    void testFindAll_Success() {

        List<Film> films = new ArrayList<>();
        films.add(new Film("The Matrix", "Wachowski Sisters", 1999));
        films.add(new Film("Inception", "Christopher Nolan", 2010));
        films.add(new Film("Interstellar", "Christopher Nolan", 2014));

        FilmResponseAll expectedResponse = new FilmResponseAll();
        ResponseEntity<FilmResponseAll> responseEntity = new ResponseEntity<>(expectedResponse, HttpStatus.OK);

        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(), eq(FilmResponseAll.class)))
                .thenReturn(responseEntity);

        // Act: llamar al método
        FilmResponseAll result = filmServiceImpl.findAll();

        // Assert: comprobar que el resultado es el esperado
        assertNotNull(result);
        assertEquals(expectedResponse, result);

        // Verificar que se llamó al método exchange con el URI correcto
        verify(restTemplate).exchange(anyString(), eq(HttpMethod.GET), any(), eq(FilmResponseAll.class));
    }

    @Test
    void findById() {
    }
}