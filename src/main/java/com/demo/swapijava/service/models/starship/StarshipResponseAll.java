package com.demo.swapijava.service.models.starship;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StarshipResponseAll {

    public String message;

    @JsonProperty("results")
    public List<Starship> starships;

}
