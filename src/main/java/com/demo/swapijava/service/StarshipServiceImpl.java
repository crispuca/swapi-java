package com.demo.swapijava.service;

import com.demo.swapijava.entities.starship.StarshipResponseAll;
import com.demo.swapijava.entities.starship.StarshipResponseById;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
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
        HttpEntity<Void> requestEntity = null;
        ResponseEntity<StarshipResponseAll> response = restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity , StarshipResponseAll.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("Success: {}", response.getStatusCode());
            return response.getBody();
        }
        log.error("Error getting people: {}", response.getStatusCode());
        throw new RuntimeException("Error");
    }


    @Override
    public StarshipResponseById findById(Long id){
        String uri = baseUrl + "/starships/"+ id;
        StarshipResponseById response = restTemplate.getForEntity(uri, StarshipResponseById.class).getBody();
        return response;
    }

}
