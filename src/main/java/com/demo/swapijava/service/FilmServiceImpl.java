package com.demo.swapijava.service;

import com.demo.swapijava.entities.film.FilmResponseAll;
import com.demo.swapijava.entities.film.FilmResponseById;
import com.demo.swapijava.entities.people.PeopleResponseById;
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
public class FilmServiceImpl extends AbstractClient implements FilmService{

    public FilmServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }
    @Override
    public FilmResponseAll findAll() {
        String uri = baseUrl + "/films";
        try {
            ResponseEntity<FilmResponseAll> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null ,
                    FilmResponseAll.class);
            return response.getBody();
        }catch (HttpClientErrorException.NotFound e) {
            throw new ResourceNotFoundException("not found");
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching");
        }


    }

    public FilmResponseById findById(Long id){

        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid ID: " + id);
        }

        String uri = baseUrl + "/films/"+ id;

        try{
            ResponseEntity<FilmResponseById> responseEntity = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null,
                    FilmResponseById.class);
            return responseEntity.getBody();

        }catch (HttpClientErrorException.NotFound e) {
            throw new ResourceNotFoundException("Film with id " + id + " not found");
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching person with id " + id, e);
        }
    }


}
