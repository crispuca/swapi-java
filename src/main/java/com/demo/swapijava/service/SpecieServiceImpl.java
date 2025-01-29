package com.demo.swapijava.service;

import com.demo.swapijava.service.models.planet.PlanetResponse;
import com.demo.swapijava.service.models.species.SpecieResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Slf4j
@Service
public class SpecieServiceImpl extends AbstractClient implements SpecieService {

    public SpecieServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public SpecieResponse findAll() {
        String uri = baseUrl + "/species";
        HttpEntity<Void> requestEntity = null;
        ResponseEntity<SpecieResponse> response = restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity , SpecieResponse.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("Success: {}", response.getStatusCode());
            return response.getBody();
        }
        log.error("Error getting people: {}", response.getStatusCode());
        throw new RuntimeException("Error");
    }

}
