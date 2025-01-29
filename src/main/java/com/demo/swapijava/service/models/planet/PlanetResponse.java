package com.demo.swapijava.service.models.planet;

import com.demo.swapijava.service.models.people.People;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PlanetResponse {

    public String status;

    @JsonProperty("results")
    public List<Planet> planets;

}
