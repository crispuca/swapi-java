package com.demo.swapijava.service;

import com.demo.swapijava.service.models.planet.PlanetResponse;
import com.demo.swapijava.service.models.starship.StarshipResponse;
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
    public StarshipResponse findAll() {
        String uri = baseUrl + "/starships";
        HttpEntity<Void> requestEntity = null;
        ResponseEntity<StarshipResponse> response = restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity , StarshipResponse.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("Success: {}", response.getStatusCode());
            return response.getBody();
        }
        log.error("Error getting people: {}", response.getStatusCode());
        throw new RuntimeException("Error");
    }

}
