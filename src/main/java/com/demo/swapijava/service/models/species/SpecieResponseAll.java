package com.demo.swapijava.service.models.species;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SpecieResponseAll {

    public String message;

    @JsonProperty("results")
    public List<Specie> species;

}
