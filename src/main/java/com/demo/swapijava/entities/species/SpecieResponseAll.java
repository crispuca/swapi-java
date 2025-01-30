package com.demo.swapijava.entities.species;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SpecieResponseAll {

    public String message;

    @JsonProperty("results")
    public List<Specie> species;

}
