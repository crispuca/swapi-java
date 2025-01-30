package com.demo.swapijava.service;

import com.demo.swapijava.service.models.people.PeopleResponseAll;
import com.demo.swapijava.service.models.people.PeopleResponseById;
import com.demo.swapijava.service.models.people.Result;
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
    public PeopleResponseAll findAll() {
        String uri = baseUrl + "/people";
        HttpEntity<Void> requestEntity = null;
        ResponseEntity<PeopleResponseAll> response = restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity , PeopleResponseAll.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("Success: {}", response.getStatusCode());
            return response.getBody();
        }
        log.error("Error getting people: {}", response.getStatusCode());
        throw new RuntimeException("Error");
    }

    public PeopleResponseById findById(Long id){
        String uri = baseUrl + "/people/"+ id;
        PeopleResponseById response = restTemplate.getForEntity(uri, PeopleResponseById.class).getBody();
        return response;
    }

}
