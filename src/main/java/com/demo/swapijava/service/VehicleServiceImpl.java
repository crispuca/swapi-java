package com.demo.swapijava.service;

import com.demo.swapijava.entities.starship.StarshipResponseById;
import com.demo.swapijava.entities.vehicle.VehicleResponseAll;
import com.demo.swapijava.entities.vehicle.VehicleResponseById;
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
public class VehicleServiceImpl extends AbstractClient implements VehicleService{


    public VehicleServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }

    @Override
    public VehicleResponseAll findAll() {
        String uri = baseUrl + "/vehicles";
        try {
            ResponseEntity<VehicleResponseAll> response = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null ,
                    VehicleResponseAll.class);
            return response.getBody();
        }catch (HttpClientErrorException.NotFound e) {
            throw new ResourceNotFoundException(" not found");
        } catch (Exception e) {
            throw new RuntimeException("An error occurred while fetching");
        }

    }


    @Override
    public VehicleResponseById findById(Long id){

        if (id == null || id <= 0) {
            throw new IllegalArgumentException("Invalid ID: " + id);
        }

        String uri = baseUrl + "/vehicles/"+ id;

        try{
            ResponseEntity<VehicleResponseById> responseEntity = restTemplate.exchange(
                    uri,
                    HttpMethod.GET,
                    null,
                    VehicleResponseById.class);

            return responseEntity.getBody();
        }catch (HttpClientErrorException.NotFound e) {
            throw new ResourceNotFoundException("Person with id " + id + " not found");
        } catch (Exception e) {
            // Manejo general de otras excepciones (conexión, timeout, etc.)
            throw new RuntimeException("An error occurred while fetching person with id " + id, e);
        }
    }

}
