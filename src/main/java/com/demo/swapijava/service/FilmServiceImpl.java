package com.demo.swapijava.service;

import com.demo.swapijava.service.models.film.FilmResponseAll;
import com.demo.swapijava.service.models.film.FilmResponseById;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Service
public class FilmServiceImpl extends AbstractClient implements FilmService{

    public FilmServiceImpl(RestTemplate restTemplate) {
        super(restTemplate);
    }
    @Override
    public FilmResponseAll findAll() {
        String uri = baseUrl + "/films";
        HttpEntity<Void> requestEntity = null;
        ResponseEntity<FilmResponseAll> response = restTemplate.exchange(
                uri, HttpMethod.GET, requestEntity , FilmResponseAll.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            log.info("Success: {}", response.getStatusCode());
            return response.getBody();
        }
        log.error("Error getting people: {}", response.getStatusCode());
        throw new RuntimeException("Error");
    }

    public FilmResponseById findById(Long id){
        String uri = baseUrl + "/films/"+ id;
        FilmResponseById response = restTemplate.getForEntity(uri, FilmResponseById.class).getBody();
        return response;
    }


}
