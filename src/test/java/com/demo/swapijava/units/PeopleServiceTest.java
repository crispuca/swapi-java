package com.demo.swapijava.units;

/*import com.demo.swapijava.entities.people.*;
import com.demo.swapijava.service.PeopleService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PeopleServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private PeopleService peopleService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void peopleGetByIdSuccessTest() throws JsonProcessingException {


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
                ArgumentMatchers.anyString(),
                ArgumentMatchers.eq(HttpMethod.GET),
                ArgumentMatchers.isNull(),
                ArgumentMatchers.eq(PeopleResponseById.class)
        )).thenReturn(ResponseEntity.ok(response));

        // Llamar al método findById
        PeopleResponseById resultResponse = peopleService.findById(1L);

        // Asegúrate de que la respuesta es la esperada
        assertNotNull(resultResponse);
        assertEquals("ok", resultResponse.getMessage());
        assertEquals("167", resultResponse.getResult().getProperties().getHeight());
    }



    @Test
    public void testFindById_NotFound() {
        // Simula un error 404 cuando no se encuentra el recurso
        when(restTemplate.exchange(
                anyString(),
                ArgumentMatchers.eq(HttpMethod.GET),
                ArgumentMatchers.any(),
                ArgumentMatchers.eq(PeopleResponseById.class)
        )).thenThrow(new HttpClientErrorException(HttpStatus.NOT_FOUND));

        // Llamar al método y verificar que lanza la excepción correcta
        Exception exception = assertThrows(ResourceNotFoundException.class, () -> {
            peopleService.findById(999L);
        });

        assertEquals("Person with id 999 not found", exception.getMessage());
    }

    @Test
    public void testFindById_InvalidId() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            peopleService.findById(-1L);
        });

        assertEquals("Invalid ID: -1", exception.getMessage());
    }
}*/
