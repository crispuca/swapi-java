package com.demo.swapijava.service;

import com.demo.swapijava.service.models.vehicle.VehicleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class VehicleServiceImpl extends AbstractClient implements VehicleService{


    public VehicleServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public VehicleResponse findAll() {
        String uri = baseUrl + "/vehicles";
        HttpEntity<Void> requestEntity = null;
        ResponseEntity<VehicleResponse> response = restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity , VehicleResponse.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("Success: {}", response.getStatusCode());
            return response.getBody();
        }
        log.error("Error getting people: {}", response.getStatusCode());
        throw new RuntimeException("Error");
    }

}
