package com.demo.swapijava.entities.film;

import com.fasterxml.jackson.annotation.JsonProperty;

public class FilmResponseById {

    public String message;

    @JsonProperty("result")
    public Result result;
}
