package com.demo.swapijava.service;

import com.demo.swapijava.entities.people.PeopleResponseById;
import com.demo.swapijava.entities.species.SpecieResponseAll;
import com.demo.swapijava.entities.species.SpecieResponseById;
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
public class SpecieServiceImpl extends AbstractClient implements SpecieService {

    public SpecieServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public SpecieResponseAll findAll() {
        String uri = baseUrl + "/species";
        HttpEntity<Void> requestEntity = null;
        ResponseEntity<SpecieResponseAll> response = restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity , SpecieResponseAll.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("Success: {}", response.getStatusCode());
            return response.getBody();
        }
        log.error("Error getting people: {}", response.getStatusCode());
        throw new RuntimeException("Error");
    }


    @Override
    public SpecieResponseById findById(Long id){

        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid ID: " + id);
        }

        String uri = baseUrl + "/species/"+ id;

        try{
            ResponseEntity<SpecieResponseById> responseEntity = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null,
                    SpecieResponseById.class);

            return responseEntity.getBody();
        }catch (HttpClientErrorException.NotFound e) {
            throw new ResourceNotFoundException("Person with id " + id + " not found");
        } catch (Exception e) {
            // Manejo general de otras excepciones (conexión, timeout, etc.)
            throw new RuntimeException("An error occurred while fetching person with id " + id, e);
        }
    }


}
