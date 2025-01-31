package com.demo.swapijava.service;

import com.demo.swapijava.entities.people.PeopleResponseAll;
import com.demo.swapijava.entities.people.PeopleResponseById;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ServerErrorException;

@Slf4j
@Service
public class PeopleServiceImpl extends AbstractClient implements PeopleService{

    public PeopleServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }
    @Override
    public PeopleResponseAll findAll() {
        String uri = baseUrl + "/people";

        try {
            ResponseEntity<PeopleResponseAll> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null ,
                    PeopleResponseAll.class);
            return response.getBody();
        }catch (HttpClientErrorException.NotFound e) {
            throw new ResourceNotFoundException(" not found");
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching");
        }



    }

    public PeopleResponseById findById(Long id){
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid ID: " + id);
        }

        String uri = baseUrl + "/people/"+ id;

        try{
            ResponseEntity<PeopleResponseById> responseEntity = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null,
                    PeopleResponseById.class);

            return responseEntity.getBody();
        }catch (HttpClientErrorException.NotFound e) {
            throw new ResourceNotFoundException("Person with id " + id + " not found");
        } catch (Exception e) {
            // Manejo general de otras excepciones (conexión, timeout, etc.)
            throw new RuntimeException("An error occurred while fetching person with id " + id, e);
        }
    }

}
