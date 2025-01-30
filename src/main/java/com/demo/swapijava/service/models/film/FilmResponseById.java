package com.demo.swapijava.service.models.film;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class FilmResponseById {

    public String message;

    @JsonProperty("result")
    public Result result;
}
