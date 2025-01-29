package com.demo.swapijava.service;

import com.demo.swapijava.service.models.planet.PlanetResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Service
public class PlanetServiceImpl extends AbstractClient implements PlanetService{

    public PlanetServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }
    @Override
    public PlanetResponse findAll() {
        String uri = baseUrl + "/planets";
        HttpEntity<Void> requestEntity = null;
        ResponseEntity<PlanetResponse> response = restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity , PlanetResponse.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("Success: {}", response.getStatusCode());
            return response.getBody();
        }
        log.error("Error getting people: {}", response.getStatusCode());
        throw new RuntimeException("Error");
    }

}
