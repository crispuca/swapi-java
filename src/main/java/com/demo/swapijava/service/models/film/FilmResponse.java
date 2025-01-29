package com.demo.swapijava.service.models.film;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FilmResponse {

    public String status;

    @JsonProperty("results")
    public List<Film> films;

}
