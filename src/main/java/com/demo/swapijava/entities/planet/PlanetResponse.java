package com.demo.swapijava.entities.planet;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PlanetResponse {

    public String status;

    @JsonProperty("results")
    public List<Planet> planets;

}
