package com.demo.swapijava.service;

import com.demo.swapijava.entities.species.SpecieResponseById;
import com.demo.swapijava.entities.starship.StarshipResponseAll;
import com.demo.swapijava.entities.starship.StarshipResponseById;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Service
public class StarshipServiceImpl extends AbstractClient implements StarshipService {

    public StarshipServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public StarshipResponseAll findAll() {
        String uri = baseUrl + "/starships";

        try {
            ResponseEntity<StarshipResponseAll> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null ,
                    StarshipResponseAll.class);
            return response.getBody();
        }catch (HttpClientErrorException.NotFound e) {
            throw new ResourceNotFoundException("not found");
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching");
        }

    }


    @Override
    public StarshipResponseById findById(Long id){

        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid ID: " + id);
        }

        String uri = baseUrl + "/starships/"+ id;
        try{
            ResponseEntity<StarshipResponseById> responseEntity = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null,
                    StarshipResponseById.class);

            return responseEntity.getBody();
        }catch (HttpClientErrorException.NotFound e) {
            throw new ResourceNotFoundException("Starship with id " + id + " not found");
        } catch (Exception e) {
            // Manejo general de otras excepciones (conexión, timeout, etc.)
            throw new RuntimeException("An error occurred while fetching starship with id " + id, e);
        }
    }

}
