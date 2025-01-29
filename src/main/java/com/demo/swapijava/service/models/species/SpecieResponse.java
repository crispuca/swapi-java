package com.demo.swapijava.service.models.species;

import com.demo.swapijava.service.models.people.People;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SpecieResponse {

    public String status;

    @JsonProperty("results")
    public List<Specie> species;

}
