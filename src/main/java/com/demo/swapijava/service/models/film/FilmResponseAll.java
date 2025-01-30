package com.demo.swapijava.service.models.film;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FilmResponseAll {

    public String message;

    @JsonProperty("result")
    public List<Result> result;

}
