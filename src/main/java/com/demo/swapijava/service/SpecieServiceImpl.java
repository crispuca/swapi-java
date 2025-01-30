package com.demo.swapijava.service;

import com.demo.swapijava.service.models.species.SpecieResponseAll;
import com.demo.swapijava.service.models.species.SpecieResponseById;
import com.demo.swapijava.service.models.starship.StarshipResponseById;
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
        String uri = baseUrl + "/species/"+ id;
        SpecieResponseById response = restTemplate.getForEntity(uri, SpecieResponseById.class).getBody();
        return response;
    }


}
