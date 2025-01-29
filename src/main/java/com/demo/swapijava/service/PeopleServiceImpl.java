package com.demo.swapijava.service;

import com.demo.swapijava.service.models.people.PeopleResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class PeopleServiceImpl extends AbstractClient implements PeopleService{

    public PeopleServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }
    @Override
    public PeopleResponse findAll() {
        String uri = baseUrl + "/people";
        HttpEntity<Void> requestEntity = null;
        ResponseEntity<PeopleResponse> response = restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity , PeopleResponse.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("Success: {}", response.getStatusCode());
            return response.getBody();
        }
        log.error("Error getting people: {}", response.getStatusCode());
        throw new RuntimeException("Error");
    }

/*    public PeopleResponse findById(Long id){
        String uri = baseUrl + "/people/{id}";
        HttpEntity<Void> requestEntity = null;
        ResponseEntity<PeopleResponse> response = restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity , PeopleResponse.class);
        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("Success: {}", response.getStatusCode());
            return response.getBody();
        }
        log.error("Error getting people: {}", response.getStatusCode());
        throw new RuntimeException("Error");
    }*/

}
