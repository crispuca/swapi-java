package com.demo.swapijava.service;

import com.demo.swapijava.service.models.starship.StarshipResponseById;
import com.demo.swapijava.service.models.vehicle.VehicleResponseAll;
import com.demo.swapijava.service.models.vehicle.VehicleResponseById;
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
    public VehicleResponseAll findAll() {
        String uri = baseUrl + "/vehicles";
        HttpEntity<Void> requestEntity = null;
        ResponseEntity<VehicleResponseAll> response = restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity , VehicleResponseAll.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("Success: {}", response.getStatusCode());
            return response.getBody();
        }
        log.error("Error getting people: {}", response.getStatusCode());
        throw new RuntimeException("Error");
    }


    @Override
    public VehicleResponseById findById(Long id){
        String uri = baseUrl + "/vehicles/"+ id;
        VehicleResponseById response = restTemplate.getForEntity(uri, VehicleResponseById.class).getBody();
        return response;
    }

}
